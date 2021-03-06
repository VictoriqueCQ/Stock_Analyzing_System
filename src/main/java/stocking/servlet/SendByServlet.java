package stocking.servlet;

import net.sf.json.JSONArray;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dell on 2017/5/23.
 */
class SendByServlet {
    private PrintWriter pw;

    void doSend(HttpServletResponse response, Object po) throws IOException {
        if (po == null) {
            try {
                this.pw = response.getWriter();
                pw.write("wrong");
                pw.flush();
                System.out.println("wrong");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            JSONArray jsonArray = JSONArray.fromObject(po);
            try {
                this.pw = response.getWriter();
                pw.write(jsonArray.toString());
                pw.flush();
                System.out.print("success");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
