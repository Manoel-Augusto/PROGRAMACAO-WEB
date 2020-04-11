package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Data;

@WebServlet("/ServletCalculo")
public class ServletCalculo extends HttpServlet {

	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String data = request.getParameter("id");
		String[] spl = data.split("/");
		byte dia = Byte.parseByte(spl[0]);
		byte mes = Byte.parseByte(spl[1]);
		short ano = Short.parseShort(spl[2]);

		Data da = null;
		try {

			da = new Data(data, ano, mes, dia);

		}

		catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar calSist = Calendar.getInstance();
		if (ano > calSist.getWeekYear()) {
			writer.println("<html><body >");
			writer.println("<h3>ATENÇÃO ANO INFORMADO É MAIOR QUE A DATA ATUAL<h3>");
			writer.println("<body><html>");
			
		}

		if (da.getData() == -1) {
			writer.println("<html><body >");
			writer.println("<h3> ATENÇÃO A DATA INFORMADA É INVÁLIDA<h3> ");
			writer.println("<body><html>");
		} else {
			writer.println("<html><body >");
			writer.println("<h3>SUA IDADE É: <h3>" + da.getIdade());
			writer.println("<body><html>");
		}

	}

}