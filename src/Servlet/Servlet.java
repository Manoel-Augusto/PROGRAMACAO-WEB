package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Data;

@WebServlet(urlPatterns = "/Servelet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		String data = req.getParameter("id");
		String[] spl = data.split("/");
		byte dia = Byte.parseByte(spl[0]);
		byte mes = Byte.parseByte(spl[1]);
		short ano = Short.parseShort(spl[2]);

		Data da = null;
		try {
			da = new Data(data, ano, mes, dia);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (da.getData() == -1) {
			writer.println("<html><body >");
			writer.println(" ATENÇÃO A DATA INFORMADA É INVÁLIDA ");
			writer.println("<body><html>");
		} else {
			writer.println("<html><body >");
			writer.println("SUA IDADE É = " + da.getIdade());
			writer.println("<body><html>");
		}

	}

}