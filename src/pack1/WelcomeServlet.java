package pack1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class WelcomeServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("userName");
        String p = request.getParameter("userPass");

        if(n==null) {
            RequestDispatcher rd1 = request.getRequestDispatcher("/loginto.html");
            rd1.forward(request, response);
        }
        if (validateLogin(n, p))//success
        {

            out.print("Welcome "+n);
            HttpSession session=request.getSession();
            session.setAttribute("uname",n);
            out.print("<br><a href='Servlet1'>Servlet1</a><br>");
            out.print("<a href='Servlet2'>Servlet2</a><br>");
            out.print("<a style=\" position: fixed; bottom: 10px; right: 10px; width: 200px;background-color: #FF0000; \" href='Logout'>Logout</a>");

            //forwards request to WelcomeServlet, and discards output from
            //current servlet(if any)

        } else //failure
        {
            out.print("Sorry UserName or Password Error!");

            //instead of index.html, any servlet also can be used or included
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");

            request.setAttribute("def", "this_parameter_added_by_servlet");

            //index.html page is included in the output along with message from current servlet
            rd.include(request, response);


        }
    }

    private boolean validateLogin(String usrnam, String passwd) {
        if(passwd.equals("111") && usrnam.equalsIgnoreCase("111"))
        {
            return true;
        }
        else
        {
            return false;
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }

}
