package stocking.data_impl.dbconnector;

import java.util.Vector;

/**
 * Created by xjwhhh on 2017/5/23.
 */
public class ParseDBConfig {

    /**
     * 读取xml配置文件
     *
     * @param path
     * @return
     */
    public Vector readConfigInfo(String path) {
//
//        String rpath = this.getClass().getResource("").getPath().substring(1);
//        System.out.println(rpath);
//        String[] pathList = rpath.split("/");
//        String newPath = "";
//        for (int i = 0; i < pathList.length - 7; i++) {
//            newPath += (pathList[i] + "/");
//        }
//        System.out.println(newPath);
//        newPath += "src/main/java/stocking/data_impl/dbconnector/";
//        newPath += path;
//        String newPath=tools.getProjectPath("src/main/java/stocking/data_impl/dbconnector/"+path);
        Vector dsConfig = null;
//        FileInputStream fi = null;
//        try {
//            fi = new FileInputStream(newPath);//读取路径文件
//            dsConfig = new Vector();
//            SAXBuilder sb = new SAXBuilder();
//            Document doc = sb.build(fi);
//            Element root = doc.getRootElement();
//            List pools = root.getChildren();
//            Element pool = null;
//            Iterator allPool = pools.iterator();
//            while (allPool.hasNext()) {
//                pool = (Element) allPool.next();
//                DBConfigBean dscBean = new DBConfigBean();
//                dscBean.setType(pool.getChild("type").getText());
//                dscBean.setName(pool.getChild("name").getText());
//                System.out.println(dscBean.getName());
//                dscBean.setDriver(pool.getChild("driver").getText());
//                dscBean.setUrl(pool.getChild("url").getText());
//                dscBean.setUsername(pool.getChild("username").getText());
//                dscBean.setPassword(pool.getChild("password").getText());
//                dscBean.setMaxconn(Integer.parseInt(pool.getChild("maxconn").getText()));
//                dsConfig.add(dscBean);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fi.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        dsConfig = new Vector();
        DBConfigBean dscBean = new DBConfigBean();
        dscBean.setType("mysql");
        dscBean.setName("stock");
        dscBean.setDriver("com.mysql.jdbc.Driver");
        dscBean.setUrl("jdbc:mysql://localhost:3306/stock?useUnicode=true&amp;characterEncoding=UTF-8&amp;autoReconnect=true&amp;failOverReadOnly=false&amp;useSSL=true&amp;zeroDateTimeBehavior=convertToNull");
        dscBean.setUsername("root");
        dscBean.setPassword("123456");
        dscBean.setMaxconn(100);
        dsConfig.add(dscBean);

        return dsConfig;
    }
}
