package pack1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gadalaya on 7/17/2017.
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession ssn=request.getSession(false);


        String n=(String)ssn.getAttribute("uname");
        if( n==null)
        {

            RequestDispatcher rd = request.getRequestDispatcher("/loginto.html");
            rd.forward(request, response);
        }
        out.print("Hello "+n+"\n");

        out.print("<a href='Servlet2'>Servlet2</a><br>");
        out.print("<a style=\" position: fixed; bottom: 10px; right: 10px; width: 200px;background-color: #FF0000;\" href='Logout'>Servlet1</a>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
