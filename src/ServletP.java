import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gadalaya on 7/23/2017.
 */
@WebServlet(name = "ServletP")
public class ServletP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String i ;out.println("hello.....");
        if(1==1)
        {
            RequestDispatcher rd = request.getRequestDispatcher("/logo.html");
            rd.forward(request, response);
        }
       else{
            out.println("nope");
        }
        out.println(request.getParameter("hh"));
       // out.println("Select an input :<form id='myform' action='ServletP2.do'> <input id = 'get1' name = 'get1' type='text' ></form>");
        //out.println("<input type ='submit' >");


    }
}
