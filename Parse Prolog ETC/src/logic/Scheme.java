package logic;

import jscheme.JScheme;
import jscheme.SchemeException;
import java.io.*;

public class Scheme {

	public static float porcentajeGrasa(float peso, float altura, int edad, int genero)
	{
		JScheme js = null;
		float resultado = -1;
		try
		{
			js = new JScheme();
			js.load(new FileReader("formulasNutricion.scsm"));
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return resultado;
		}
		
		resultado = (float) js.call("porcentajeGrasa", peso, altura, edad, genero);
		return resultado;
	}
}
