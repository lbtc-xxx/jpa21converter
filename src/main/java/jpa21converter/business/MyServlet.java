package jpa21converter.business;

import jpa21converter.entity.MyCompositeKeyTable;
import jpa21converter.entity.MySimpleTable;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class MyServlet extends HttpServlet {

    @EJB
    private MyEjb myEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myEjb.saveMySimpleTable();
        myEjb.saveMyCompositeKeyTable();

        final PrintWriter writer = resp.getWriter();
        writer.write("<html><body>\n\n");
        writer.write(dumpMySimpleTable());
        writer.write(dumpMyCompositeKeyTable());
        writer.write("</body></html>\n");
    }

    private String generateTable(String title, Collection data, String... columns) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<h2>").append(title).append("</h2>\n");
        sb.append("<table border='1'>\n");
        sb.append("<thead>\n<tr>\n");
        for (String column : columns) {
            sb.append("<th>").append(column).append("</th>\n");
        }
        sb.append("</tr>\n</thead>\n");
        sb.append("<tbody>\n");
        for (Object o : data) {
            sb.append(o).append('\n');
        }
        sb.append("</tbody>\n</table>\n");
        sb.append('\n');
        return sb.toString();
    }

    private String dumpMySimpleTable() {
        final List<MySimpleTable> mySimpleTables = myEjb.fetchMySimpleTable();
        return generateTable("MySimpleTable", mySimpleTables, "id", "someLocalDate", "someLocalDateTime");
    }

    private String dumpMyCompositeKeyTable() {
        final List<MyCompositeKeyTable> myCompositeKeyTables = myEjb.fetchMyCompositeKeyTable();
        return generateTable("MyCompositeKeyTable", myCompositeKeyTables, "someLocalDate", "someLocalDateTime");
    }
}
