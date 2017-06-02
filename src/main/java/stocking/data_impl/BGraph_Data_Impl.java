package stocking.data_impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import stocking.data_service.BGraph_Data_Service;
import stocking.po.BGraphPO;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xjwhhh on 2017/5/31.
 */
public class BGraph_Data_Impl implements BGraph_Data_Service {
    Tools tools = new Tools();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public BGraphPO get(String type, Date start, Date end, String isHold, int interval, String isPla, JSONArray stocks) {
        String startDate = formatter.format(start);
        String endDate = formatter.format(end);
        try {
            List<String> commands = new LinkedList<String>();
            commands.add("python");
            commands.add(tools.getProjectPath("src\\main\\java\\stocking\\python_Impl\\BGraph.py"));
            String value=type+"?"+startDate+"?"+endDate+"?"+isHold+"?"+String.valueOf(interval)+"?"+isPla+"?"+tools.jsonArrayToString(stocks);
//            commands.add(type);//策略类型
//            commands.add(startDate);//开始日期
//            commands.add(endDate);//结束日期
//            commands.add(isHold);//是否是形成期
//            commands.add(String.valueOf(interval));//已知时间
//            commands.add(isPla);//是否为板块
//            commands.add(tools.jsonArrayToString(stocks));//股票列表转成的string
            commands.add(value);

            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            Process pr = processBuilder.start();
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(pr.getInputStream(), "gbk"));
            String line = in.readLine();
            int num = Integer.parseInt(line);
            List<Double> profits = new ArrayList<Double>();
            List<Double> winChance = new ArrayList<Double>();
            for (int i = 0; i < num; i++) {
                profits.add(Double.parseDouble(in.readLine()));
//                System.out.print(profits.get(i));
            }
            for (int i = 0; i < num; i++) {
                winChance.add(Double.parseDouble(in.readLine()));
            }
            BGraphPO bGraphPO = new BGraphPO(profits, winChance);
            in.close();
            return bGraphPO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public static void main(String [] args) throws  Exception{
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = formatter.parse("2016-03-01");
//        Date endDate = formatter.parse("2016-06-01");
//        String[] array = new String[]{"000001", "000002", "000004", "300001", "300002", "300003"};
//        JSONArray jsonArray = JSONArray.fromObject(array);
////        System.out.print(bGraph_data_service.get("1", startDate, endDate, "1", 20, "0", jsonArray) == null);
//        BGraph_Data_Service bGraph_data_service=new BGraph_Data_Impl();
//        BGraphPO bGraphPO = bGraph_data_service.get("1", startDate, endDate, "1", 20, "0", jsonArray);
//        JSONObject json = JSONObject.fromObject(bGraphPO);//将java对象转换为json对象
//        String str = json.toString();//将json对象转换为字符串
//        System.out.print(str);
//    }
}