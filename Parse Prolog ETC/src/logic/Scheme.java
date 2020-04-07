package logic;

import jscheme.JScheme;
import jscheme.SchemeException;
import java.io.*;

public class Scheme {

	public static double porcentajeGrasa(float peso, float altura, int edad, int genero)
	{
		JScheme js = null;
		double resultado = -1;
		try
		{
			js = new JScheme();
			js.load(new FileReader("formulasNutricion.rkt"));
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return resultado;
		}
		
		resultado = (double) js.call("porcentajeGrasa", peso, altura, edad, genero);
		return resultado;
	}
	
	public static double caloriasMantenerPeso(float peso, float altura, int edad, int genero, int nivelEJ)
	{
		JScheme js = null;
		double resultado = -1;
		try
		{
			js = new JScheme();
			js.load(new FileReader("formulasNutricion.rkt"));
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return resultado;
		}
		
		resultado = (double) js.call("caloriasMantenerPeso", peso, altura, edad, nivelEJ, genero);
		return resultado;
	}
	
	public static double caloriasBajarPeso(float peso, float altura, int edad, int genero, int nivelEJ)
	{
		JScheme js = null;
		double resultado = -1;
		try
		{
			js = new JScheme();
			js.load(new FileReader("formulasNutricion.rkt"));
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return resultado;
		}
		
		resultado = (double) js.call("caloriasBajarPeso", peso, altura, edad, nivelEJ, genero);
		return resultado;
	}
}
