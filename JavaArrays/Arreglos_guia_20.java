package Taller_Arreglos_1;

import java.util.Scanner;

public class Arreglos_guia_20 {

	public static void main(String[] args) {
		saludar();
		System.out.println("Ejercicios 2 y 3 guía 20 de arreglos:");
		//Ejercicio 1
		// 1. a
		double []A1 = new double [100000];
		boolean []A2 = new boolean[1];
		int []A3 = new int [450];
		String []A4 = new String [150];
		System.out.println("Ejercicio 1");
		System.out.println("   Ejercicio 1.a");
		System.out.println("\tLa longitud de A1 es: "  + A1.length);
		System.out.println("\tLa longitud de A2 es: "  + A2.length);
		System.out.println("\tLa longitud de A3 es: "  + A3.length);
		System.out.println("\tLa longitud de A4 es: "  + A4.length);
		System.out.println("");
		// 1.b
		System.out.println("   Ejercicio 1.b");
		double A[];
		A = new double[3];
		int x;
		for (int i=0; i<A.length; i++)
			A[i] = i*3;
		x= (int) (A[0]+ A[1]+ A[2]);
		for (int i=0; i<A.length; i++)
			System.out.println("\tEl valor de A[ " + i + " ] es: " + A[i]);
		System.out.println("\tEl valor de x es: " + x);
		System.out.println("");
		System.out.println("Ejercicio 2");
		System.out.println("   Ejercicio 2.a");
		System.out.println("   Recibe el tamaño del arreglo para en cada elemnto inicializarlo con 3*n");
		int Arr[] = null;
		inicia1(Arr);
		System.out.println("   Ejercicio 2.b");
		System.out.println("    La función regresa el\r\n"
				+ "número de veces que se repite el valor de x en el arreglo");
		int Arr2[] = null;
		int tm = 0, valor = -1;
		while(tm == 0)
			tm =  ValidarNumeroInt();
		 Arr2 = new int[tm];
		 llenarArreglo(Arr2);
		 while(valor == -1)
				valor = ValidarNumeroInt_0( "el valor a conocer cuántas veces se ha repetido en el arreglo");
		 imprimirArreglo(Arr2, "Arr2");
		 System.out.println("\tEl valor " + valor + " está " + cuentaRepeticiones(Arr2, valor) + " repetido");
		 System.out.println("Ejercicio 3");
		 System.out.println("   Ejercicio 3.a");
		 System.out.println("   Invierte el último arreglo");
		 invierte(Arr2);
		 imprimirArreglo(Arr2, "Arr2");
		 System.out.println("   Ejercicio 3.b");
		 System.out.println("   Ordena el último arreglo de mayor a menor");
		 ordena2(Arr2);
		 imprimirArreglo(Arr2, "Arr2");
}
public static  int ValidarNumeroInt() {
	Scanner entrada = new Scanner (System.in);
	int tm;
	try {
		System.out.println("   Ingrese el tamaño del arreglo ");
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
public static  int ValidarNumeroInt_0(String texto) {
	Scanner entrada = new Scanner (System.in);
	int tm;
	try {
		System.out.println("   Ingrese " + texto);
		tm=entrada.nextInt();
	}
	catch(Exception ioe) {
		System.out.println( " Error en la lectura: " +ioe.getMessage());
		System.out.println( " Debe ser un número entero y positivo (incluye el 0)");
		return 0;
	}
	if (tm < 0)
		return -1;
	return tm;
}
public static void imprimirArreglo(int Arr[], String nombreArreglo)
{
	System.out.println(nombreArreglo+ ":");
	for (int i=0; i<Arr.length; i++)
		System.out.print("[ "+ Arr[i]+ " ]");
	System.out.println("");
}
public static void inicia1(int Arr[]) {
	int tm = 0;
	 while(tm == 0)
		 tm = ValidarNumeroInt();
	 Arr = new int[tm];
	 for (int i=0; i< Arr.length; i++)
	 {
			Arr[i] = i*3;
			System.out.println("\tEl valor de Arr[ " + i + " ] es: " + Arr[i]);
	 }
}
public static void llenarArreglo(int Arr2[]) {
	int valor = -1;
	
	 for (int i=0; i< Arr2.length; i++)
	 {
			while(valor == -1)
				valor = ValidarNumeroInt_0( "el valor a ingresar");
			Arr2[i] = valor;
			System.out.println("\tEl valor de Arr2[ " + i + " ] es: " + Arr2[i]);
			valor = -1;
	 }
}
public static int cuentaRepeticiones(int Arr2[], int x) {
	int contador = 0;
	for (int i=0; i< Arr2.length; i++)
	 {
		if (Arr2[i] == x)
			contador++;
	 }
	return contador;	
}
public static void invierte(int Arr[])
{
	int ultimo, inicio;
	int c = 0;
	
	ultimo = Arr.length - 1;
	for (inicio = 0; inicio <= ultimo; inicio++)
	{
		c = Arr[inicio];
		Arr[inicio] = Arr[ultimo];
		Arr[ultimo] = c;
		ultimo--;
	}
}
public static void ordena2(int Arr[]){
	int i = 0, j = 0, temp = 0;
	
	for(i = 0; i < Arr.length; i++)
	{
		for (j = i + 1; j < Arr.length ; j++)
		{
			if(Arr[i] < Arr[j])
			{
				temp = Arr[i];
				Arr[i] = Arr[j];
				Arr[j] = temp;
			}
		}
	}
}
public static void saludar()
{
	System.out.println("*************************************************************");
	System.out.println("*     UNIVERSIDAD DISTRITAL FRANCISCO JOSE DE CALDAS        *");
	System.out.println("*                    INGENIERIA ELECRICA                    *");
	System.out.println("*         007-742 PROGRAMACION ORIENTADA A OBJETOS          *");
	System.out.println("*             ANGIE XIMENA CASTAÑO 20191007002              *");
	System.out.println("*                  9 DE DICIEMBRE DEL 2020                  *");
	System.out.println("*                2 y 3 GUIA 20 / ARREGLOS                   *");
	System.out.println("*************************************************************");


}
}
