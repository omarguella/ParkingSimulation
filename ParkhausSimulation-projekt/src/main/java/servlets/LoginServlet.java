package servlets;
import Classes.CheckingLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String userParams = CheckingLogin.CheckingUser(request.getParameter("userName"), request.getParameter("password"));
        switch (userParams) {
            case "admin":
                RequestDispatcher rq_admin = request.getRequestDispatcher("Admin.jsp");
                rq_admin.forward(request, response);
                break;
            case "kunde":
                RequestDispatcher rq_user = request.getRequestDispatcher("Kunde.jsp");
                rq_user.forward(request, response);
                break;
            case "wrongID":
                out.println("Nutzername oder Passwort stimmen nicht mit den gegebenen Daten überein.");
                RequestDispatcher rs_inc = request.getRequestDispatcher("Connect.jsp");
                rs_inc.include(request, response);
                break;
        }
    }
    
  
}
