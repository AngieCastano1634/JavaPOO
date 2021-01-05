package Taller_Arreglos_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Arreglo_matrices {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int m1_filas = 0, m1_columnas = 0, m2_filas = 0, m2_columnas = 0;
		int m3_filas = 0, m3_columnas = 0, m4_filas = 0, m4_columnas = 0;
		int [][]Matriz1 = null;
		int [][]Matriz2 = null;
		int [][]Matriz3 = null;
		int [][]Matriz4 = null;
		int tm = 0;
		boolean multiplicable = false, sumable = false;
		saludar();
		System.out.println("Programa sobre matrices:");
		System.out.println("Ejercicio 4. Multiplicacion de 2 matrices");
		while (multiplicable == false)
		{
			while(m1_filas == 0)
				m1_filas = ValidarNumeroInt("cantidad de filas matriz 1 a multiplicar");
			while(m1_columnas == 0)
				m1_columnas = ValidarNumeroInt("cantidad de columnas matriz 1 a multiplicar");
			while(m2_filas == 0)
				m2_filas = ValidarNumeroInt("cantidad de filas matriz 2 a multiplicar");
			while(m2_columnas == 0)
				m2_columnas = ValidarNumeroInt("cantidad de columnas matriz 2 a multiplicar ");
			
			if(m1_columnas == m2_filas)
			{
				multiplicable = true;
				break;
			}
				System.out.println("Las matrices no son multiplicables, ingrese de nuevo los datos");
				continue;
		}
		Matriz1 = new int[m1_filas][m1_columnas];
		Matriz2 = new int[m2_filas][m2_columnas];
		if (menu())
		{
			llenarMatrizAutomaticamente(Matriz1,m1_filas, m1_columnas, "1");
			llenarMatrizAutomaticamente(Matriz2,m2_filas, m2_columnas, "2");
		}
		else
		{
			llenarMatrizManualmente(Matriz1,m1_filas, m1_columnas, "1");
			llenarMatrizManualmente(Matriz2,m2_filas, m2_columnas, "2");
		}
		
		imprimirMatriz(Matriz1, m1_filas, m1_columnas , "1");
		imprimirMatriz(Matriz2, m2_filas, m2_columnas , "2");
		int [][] MatrizResultante = multiplicacionDematrices(Matriz1,Matriz2, m1_filas, m2_columnas, m1_columnas);
		imprimirMatriz(MatrizResultante, m1_filas, m2_columnas , "Matriz resultante");
		System.out.println("\nEjercicio 5. Suma de 2 matrices");
		while (sumable == false)
		{
			while(m3_filas == 0)
				m3_filas = ValidarNumeroInt("cantidad de filas matriz 1 a sumar");
			while(m3_columnas == 0)
				m3_columnas = ValidarNumeroInt("cantidad de columnas matriz 1 a sumar");
			while(m4_filas == 0)
				m4_filas = ValidarNumeroInt("cantidad de filas matriz 2 a sumar");
			while(m4_columnas == 0)
				m4_columnas = ValidarNumeroInt("cantidad de columnas matriz 2 a sumar");
			if(m3_columnas == m4_columnas && m3_filas == m4_filas)
			{
				sumable = true;
				break;
			}
				System.out.println("Las matrices no se pueden sumar, ingrese de nuevo los datos");
				continue;
		}
		Matriz3 = new int[m3_filas][m3_columnas];
		Matriz4 = new int[m4_filas][m4_columnas];
		if (menu())
		{
			llenarMatrizAutomaticamente(Matriz3,m3_filas, m3_columnas, "1");
			llenarMatrizAutomaticamente(Matriz4,m4_filas, m4_columnas, "2");
		}
		else
		{
			llenarMatrizManualmente(Matriz3,m3_filas, m3_columnas, "1");
			llenarMatrizManualmente(Matriz4,m4_filas, m4_columnas, "2");
		}
		
		imprimirMatriz(Matriz3, m3_filas, m3_columnas , "1");
		imprimirMatriz(Matriz4, m4_filas, m4_columnas , "2");
		int [][]MatrizSuma = sumaDematrices(Matriz3, Matriz4, m3_filas, m3_columnas);
		imprimirMatriz(MatrizSuma, m3_filas, m3_columnas , "resultado de la suma de matrices:");
		System.out.println("\nEjercicio 6. Matriz en espiral");
		while(tm == 0)
		{
			tm = ValidarNumeroInt("el tamaño de la matriz en espiral, debe ser un número impar");
			if (tm % 2 == 0)
			{
				System.out.println("Debe ser un número impar");
				tm = 0;
			}
		}
		int MatrizEspiral[][] = matricesEspiral(tm);
		imprimirMatriz(MatrizEspiral, tm, tm , "matriz en espiral: ");
			
	}
	public static void saludar()
	{
		System.out.println("*************************************************************");
		System.out.println("*     UNIVERSIDAD DISTRITAL FRANCISCO JOSE DE CALDAS        *");
		System.out.println("*                    INGENIERIA ELECRICA                    *");
		System.out.println("*         007-742 PROGRAMACION ORIENTADA A OBJETOS          *");
		System.out.println("*             ANGIE XIMENA CASTAÑO 20191007002              *");
		System.out.println("*                  9 DE DICIEMBRE DEL 2020                  *");
		System.out.println("*                4 y 5 GUIA 20 / MATRICES                   *");
		System.out.println("*************************************************************");


	}
	public static void llenarMatrizManualmente(int[][] Matriz, int filas, int columnas, String dato1) throws IOException
	{
		int i = 0, j = 0;
		String dato = "";
		boolean validarEntero = false;
		System.out.println("Ingresa el valor de la matriz"+ dato1 +" en la posición: ");
		for (i = 0; i < filas; i++)
		{
			for (j = 0; j < columnas; j++)
			{
				while(validarEntero == false)
				{
					dato = recibirEntrada("[" + String.valueOf(i) + "," + String.valueOf(j) + "]");
					validarEntero = validarEntradaInt(dato);
				}
				
				validarEntero = false;
				Matriz[i][j] = Integer.parseInt(dato);
			}
		}
	}
	public static void llenarMatrizAutomaticamente(int[][] Matriz, int filas, int columnas, String dato) throws IOException
	{
		Random random = new Random();
		int i = 0, j = 0;
		for (i = 0; i < filas; i++)
		{
			for (j = 0; j < columnas; j++)
			{
				Matriz[i][j] = random.nextInt(10);
			}
		}
	}
	public static void imprimirMatriz(int[][] Matriz, int filas, int columnas , String dato) throws IOException
	{
		int i = 0, j = 0;
		System.out.println("Matriz " + dato + ":");
		 
		for (i = 0; i < filas; i++)
		{
			for (j = 0; j < columnas; j++)
			{
				System.out.format("[ %4d]" ,Matriz [i][j]);
				
			}
			System.out.print("\n");
		}
	}
	public static  int ValidarNumeroInt(String dato) {
		Scanner entrada = new Scanner (System.in);
		int tm;
		try {
			System.out.println("   Ingrese " + dato);
			tm=entrada.nextInt();
		}
		catch(Exception ioe) {
			System.out.println( " Error en la lectura: " +ioe.getMessage());
			System.out.println( " Debe ser un número entero y positivo");
			return 0;
		}
		if (tm < 1)
			return 0;
		return tm;
	}
	public static String recibirEntrada(String dato) throws IOException{
		String ingreso = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader entrada = new BufferedReader(isr);
		System.out.print("Ingrese " + dato + "\n");
		ingreso = entrada.readLine();
		return ingreso;
	}
	public static boolean validarEntradaInt(String ingreso) {
		try {Integer.parseInt(ingreso);
			return true;
		}
		catch(Exception ioe) {
			System.out.println( "Error en la lectura: " +ioe.getMessage());
			return false;
		}
	}
	public static boolean menu() throws IOException {
		boolean validarEntero = false;
		String dato = null;
		int opc = 0;
		while(validarEntero == false)
		{
			System.out.println("Si desea llenar manualmente la matriz de  datos ingrese 1");
			System.out.println("Si desea llenar la matriz automáticamente de  datos ingrese 2");
			Scanner entrada = new Scanner (System.in);
			try
			{
				opc = entrada.nextInt();
			}
			catch(Exception ioe) {
				System.out.println( "Error en la lectura: " +ioe.getMessage());
				validarEntero =  false;
				continue;
			}
			System.out.println(opc);
			if (opc < 1 && opc > 2)
			{
				System.out.println("El número debe estar entre 1 y 2");
				validarEntero = false;
			}
			else if(opc == 1)
				return false;
			else if (opc == 2)
				return true;
		}
		return true;
		
	}
	public static int[][] multiplicacionDematrices(int[][] Matriz1, int[][] Matriz2, int m1_filas, int m2_columnas, int m1_columnas)
	{
		int[][] MatrizResultante = new int [m1_filas][m2_columnas];
		int i = 0, j = 0, k = 0, resultado = 0;
		for (i = 0; i < m1_filas; i++)
		{
			for (j = 0; j < m2_columnas ; j++)
			{
				resultado = 0;
				for (k = 0; k < m1_columnas; k++)
				{
					resultado += Matriz1[i][k] * Matriz2[k][j]; 
				}
				MatrizResultante[i][j] = resultado;
			}
		}
		return MatrizResultante;
	}
	public static int[][] sumaDematrices(int[][]Matriz3, int[][] Matriz4, int m3_filas, int m3_columnas){
		int i=0, j=0;
		int [][]MatrizSuma = new int[m3_filas][m3_columnas];
		for(i = 0; i < m3_filas; i++)
		{
			for(j = 0; j < m3_columnas; j++)
			{
				MatrizSuma[i][j] = Matriz3[i][j] + Matriz4[i][j];
			}
		}
		return MatrizSuma;
	}
	public static int [][] matricesEspiral(int tm) {
		int itemp, jtemp;
		itemp = 0;
		jtemp = 0;
		int d = tm - 1;
		int contador = 0;
		int [][]MatrizEspiral = new int[tm][tm];
		int adentro = 0;
		while(d > 0 && tm > 1)
		{
			int i;
			int j;
			i = adentro;
			j = adentro;
			int dtemp = 0;
			for(j = adentro; dtemp < d; j++, contador ++, dtemp ++)
			{
				MatrizEspiral[i][j] = contador;
			}
			for(i = adentro, dtemp = 0; dtemp < d; i++, contador ++, dtemp ++)
			{
				MatrizEspiral[i][j] = contador;
			}
			for(dtemp = 0; dtemp < d; j--, contador ++, dtemp ++)
			{
				MatrizEspiral[i][j] = contador;
			}
			for(dtemp = 0; dtemp < d; i--, contador ++, dtemp++)
			{
				MatrizEspiral[i][j] = contador;
			}
			d -= 2;

			adentro ++;
		}
		MatrizEspiral[tm / 2][tm / 2] = contador;
		return MatrizEspiral;
		
	}
}
