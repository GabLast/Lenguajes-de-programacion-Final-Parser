package logic;

import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

public class Consulta {
	
	public static Map<String, Term>[] consultar(String consulta) {
		// TODO Auto-generated method stub

		String string = "consult('./src/prolog.pl')";
		Query query = new Query(string);
		System.out.println("El archivo a consultar existe: " + (query.hasSolution() ? "True" : "False"));
		
		if(query.hasSolution())
		{
			String s3 = consulta;
			Query q3 = new Query(s3);		
			Map<String, Term>[] respuestas =  q3.allSolutions();
			
			return respuestas;
		}
		else
			return null;

 	}
}
