package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.LoginSenha;

/**
 * Servlet implementation class Restrito
 */
@WebServlet("/restrito")
public class ServletRestrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getSession(false) != null) {
    		
    		PrintWriter out = response.getWriter();
    		
    		LoginSenha ref = (LoginSenha)request.getSession(false).getAttribute("aut");
    		
    		out.println("<html>");
    		out.println("<head>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("Olá: " + ref.getUsuario() + "<br/>");
    		out.println("Você acessou um área restrita em: " + new Date() + "<br/>");
    		out.println("<br>");
    		out.println("<a href=\"invalidar\"> Logout </a>");
    		out.println("<br>");
    		out.println("<br>");
    		out.println("<a href=\"calculo.html\"> CALCULAR IDADE </a>");
    		out.println("</body>");
    		out.println("</html>");
    	
    	} else {
			
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("TIPO DE ACESSO INDEVIDO.");
			out.println("<a href=\"index.html\"> LOGAR NOVAMENTE ? </a>");
			out.println("</body>");
			out.println("</html>");
			
		}
    }
}
