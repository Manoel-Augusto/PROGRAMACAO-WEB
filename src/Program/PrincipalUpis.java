package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Entities.Data;

public class PrincipalUpis {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNasc;
		dataNasc = sdf.parse("12/05/2017");
		//Data d = new Data(sdf.parse("12/05/2017"));
		
		
		Data dd = new Data("08/08/1990", (short)2019, (byte)1, (byte)1);
		dd.CalcularIdade();
		
		System.out.println(dd.getIdade());
		
		System.out.println(dd.getDia());
		System.out.println(dd.getMes());
		System.out.println(dd.getAno());
	}

}
