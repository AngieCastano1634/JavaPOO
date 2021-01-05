package calcularResistecias;

  
import java.io.*; 
import java.util.*; 
public class AplicacionResistencia {

	public static void main(String[] args) throws IOException {
        double resultadoPorDebajo = 0, resultadoPorEncima = 0, resistencia_neta = 0;
		Vector<String> banda1_3 = new Vector<String>(10);
        banda1_3.add("negro");
        banda1_3.add("marron");
        banda1_3.add("rojo");
        banda1_3.add("naranja");
        banda1_3.add("amarillo");
        banda1_3.add("verde");
        banda1_3.add("azul");
        banda1_3.add("violeta");
        banda1_3.add("gris");
        banda1_3.add("blanco");
		Vector<String> banda4v = new Vector<String>(10);
        banda4v.add("negro");
        banda4v.add("marron");
        banda4v.add("rojo");
        banda4v.add("naranja");
        banda4v.add("amarillo");
        banda4v.add("verde");
        banda4v.add("azul");
        banda4v.add("violeta");
        Vector<String> tolerancia = new Vector<String>(9);
        tolerancia.add("negro");
        tolerancia.add("marron");
        tolerancia.add("verde");
        tolerancia.add("azul");
        tolerancia.add("violeta");
        tolerancia.add("gris");
        tolerancia.add("dorado");
        tolerancia.add("plateado");
        tolerancia.add("ninguno");
        Vector<Double> tolerancia_numero = new Vector<Double>(9);
        tolerancia_numero.add(0.01);
        tolerancia_numero.add(0.02);
        tolerancia_numero.add(0.005);
        tolerancia_numero.add(0.0025);
        tolerancia_numero.add(0.001);
        tolerancia_numero.add(0.0005);
        tolerancia_numero.add(0.05);
        tolerancia_numero.add(0.1);
        tolerancia_numero.add(0.2);
        Vector<String> tolerancia_porcentaje = new Vector<String>(9);
        tolerancia_porcentaje.add("+/-1%");
        tolerancia_porcentaje.add("+/-2%");
        tolerancia_porcentaje.add("+/-0.5%");
        tolerancia_porcentaje.add("+/-0.25%");
        tolerancia_porcentaje.add("+/-0.10%");
        tolerancia_porcentaje.add("+/-0.05%");
        tolerancia_porcentaje.add("+/-5%");
        tolerancia_porcentaje.add("+/-10%");
        tolerancia_porcentaje.add("+/-20%");
        double banda1, banda2, banda3, banda4, banda5;
        int resultado_tolerancia = -1;
        int opc = 9;
        saludar();
        System.out.println("Este es un programa para calcular una resistencia de 5 bandas");
        do
        {
        banda1 =  repetirMenu(banda1_3, 10, "banda 1");
        banda2 =  repetirMenu(banda1_3, 10, "banda 2");
        banda3 =  repetirMenu(banda1_3, 10, "banda 3");
        banda4 =  repetirMenuBanda4(banda4v, 8,"banda 4");
        resultado_tolerancia = repetirMenutolerancia(tolerancia, 9, "banda 5", tolerancia_porcentaje);
        banda5 = tolerancia_numero.get(resultado_tolerancia);
        
        Resistencia nuevaResistencia = new Resistencia(banda1, banda2, banda3, banda4, banda5);
        resistencia_neta = nuevaResistencia.resistenciaSinCalcularTolerancia();
        resultadoPorDebajo = nuevaResistencia.ResistenciaConToleranciaNegativa();
    			resultadoPorEncima = nuevaResistencia.ResistenciaConToleranciaPositiva();
			if (banda4 > 0 &&  banda4 < 4)
			{
				System.out.print("La resistencia neta es: "+resistencia_neta/1000.0+ "K ohmios\n" +"La resistencia está entre " + resultadoPorDebajo/1000.0 + "K ohmios y "+ resultadoPorEncima/1000.0 + "K ohmios\n");
			}
			else if (banda4 > 3)
			{
				System.out.print("La resistencia neta es: "+resistencia_neta/1000000.0+ "M ohmios\n" +"La resistencia está entre " + resultadoPorDebajo/1000000.0 + "M ohmios y "+ resultadoPorEncima/1000000.0 + "M ohmios\n");
			}
			else {
			
				System.out.print("La resistencia neta es: "+ resistencia_neta + "ohmios\n" + "La resistencia está entre " + resultadoPorDebajo + " ohmios y "+resultadoPorEncima+ " ohmios\n");
			}
			opc = ValidarEntero(" 9 para salir del menú, de lo contrario ingrese cualquier otro número entero:\n");
        } while (opc != 9);
        System.out.println("Gracias por usar el programa :)");
        

	}
	public static void saludar()
	{
		System.out.println("*************************************************************");
		System.out.println("*     Buenas tardes :)        *");
		System.out.println("*************************************************************");


	}
	public static void MenuDeOpcionesDeResistencias(Vector banda1_3, int ultimo)
	{
		int i = 0;
		for (i = 0; i < ultimo; i++)
		{
			System.out.println("Por favor escriba " + banda1_3.get(i)+ " para " + i);
		}
	}
	public static void MenuDeOpcionesDeResistenciasTolerancia(Vector tolerancia, int ultimo, Vector tolerancia_porcentaje)
	{
		int i = 0;
		for (i = 0; i < ultimo; i++)
		{
			System.out.println("Por favor escriba " + tolerancia.get(i)+ " para " + tolerancia_porcentaje.get(i)+ " de tolerancia");
		}
	}
	public static String recibirEntrada(String dato) throws IOException{
		String ingreso = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader entrada = new BufferedReader(isr);
		System.out.print("Ingrese " + dato + "\n");
		ingreso = entrada.readLine();
		return ingreso;
	}
	public static double repetirMenu(Vector banda1_3, int ultimo, String dato) throws IOException {
		String entrada = "";
		double banda = -1;
        do {
        	MenuDeOpcionesDeResistencias(banda1_3, ultimo);
        	entrada = recibirEntrada(dato);
        	banda = banda1_3.indexOf(entrada.toLowerCase());
        } while(banda == -1); 
        return banda;
	}
	public static double repetirMenuBanda4(Vector banda4, int ultimo, String dato) throws IOException {
		String entrada = "";
		double banda = -1;
        do {
        	MenuDeOpcionesDeResistencias(banda4, ultimo);
        	entrada = recibirEntrada(dato);
        	banda = banda4.indexOf(entrada.toLowerCase());
        } while(banda == -1); 
        return banda;
	}
	public static int repetirMenutolerancia(Vector tolerancia, int ultimo, String dato,  Vector tolerancia_numero) throws IOException {
		String entrada = "";
		int banda = -1;
        do {
        	MenuDeOpcionesDeResistenciasTolerancia(tolerancia, ultimo, tolerancia_numero);
        	entrada = recibirEntrada(dato);
        	banda = tolerancia.indexOf(entrada.toLowerCase());
        } while(banda == -1); 
        return banda;
	}
	public static boolean validarEntradaInt(String ingreso) {
		int entero = 0;
		try {
			entero = Integer.parseInt(ingreso);
			return true;
		}
		catch(Exception ioe) {
			System.out.println( "Error en la lectura: " +ioe.getMessage());
			return false;
		}
	}
	public static int ValidarEntero(String dato) throws IOException {
		boolean bandera  = false;
		String ingreso = "";
		do {
			ingreso = recibirEntrada(dato);
			bandera = validarEntradaInt(ingreso);
			
		} while(bandera == false);
		return Integer.parseInt(ingreso);
	}

}
