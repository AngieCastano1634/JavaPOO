package CuboMagico;

import java.util.Scanner;
public class CuboMagic {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);

		boolean ValidarNumero=false;
		int tm = 0, i, j;
		int [][]cuadradoMagico = null;
		while(tm == 0) {
			tm = ValidarNumero();
		}
			cuadradoMagico = new int [tm][tm];
			RellenarDeCeros(cuadradoMagico,tm);
			ValidarNumero = true;
		
			generarCuadroMagico(cuadradoMagico,tm);
			imprimirArray(cuadradoMagico,tm);
			

	}
	public static void RellenarDeCeros(int [][]cuadradoMagico, int tm) {
		for ( int i=0;i<tm;i++) {
			for( int j=0 ; j<tm;j++) {
				cuadradoMagico[i][j]= 0;
			}
		}
	}
	public static void imprimirArray(int[][]cuadradoMagico, int tm)
	{
		for (int x=0;x<tm;x++) {
			int cubito= 0;
			for(int y=0 ; y<tm;y++) {
				cubito= cuadradoMagico[x][y];
				System.out.print("[ "+cubito +  " ]");
			}
			System.out.print("\n");
		}
	}
	public static void generarCuadroMagico(int [][]cuadradoMagico, int tm)
	{
		int tamaño = -1;
		int temp=1;
		int pinicio = 0;
		int i=0, j=0;
		int jtemp=0,itemp=0;
		
		pinicio=tm/2;
		i=pinicio;		
		j=pinicio;		
		cuadradoMagico[i][j]=1;
		while(temp  !=(tm*tm))
		{
			itemp = i;
			jtemp = j;
			itemp--;
			jtemp++;
			if (itemp < 0)
				itemp = tm - 1;
			if(jtemp >= tm)
				jtemp = 0;
			if(cuadradoMagico[itemp][jtemp] == 0)
			{
				temp++;
				cuadradoMagico[itemp][jtemp] = temp;
			}
			else {
				temp++;
				itemp = i + 1;
				jtemp = j;
				if (i + 1 >= tm)
					itemp = 0;
				cuadradoMagico[itemp][jtemp] = temp;
			}
			i = itemp;
			j = jtemp;
		}
	}
	public static  int ValidarNumero() {
		Scanner entrada = new Scanner (System.in);
		int tm;
		try {
			System.out.println("Ingrese el tamaño de el cubo (Solo impares ) ");
			tm=entrada.nextInt();
		}
		catch(Exception ioe) {
			System.out.println( "Error en la lectura: " +ioe.getMessage());
			return 0;
		}
		if (tm < 0 || tm % 2 == 0)
			return tm;
		return tm;
		
	}
	public static void saludar()
	{
		System.out.println("*************************************************************");
		System.out.println("Buenas tardes :)");
		System.out.println("*************************************************************");


	}
}