package UniversidadBD;

import java.util.Scanner;

public class AplicacionBDUniversidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner entrada = new Scanner (System.in);
		
		int op=0;
		int opln=0;
        int opt=0;
        String num, apell;
        System.out.println("Programa para ingreso de datos de la universidad");
		saludar();
		do{
		clearConsole();
        System.out.println("Desea Ingresar  ?");
        System.out.println("(1) Si   (2) No ");
        opln=entrada.nextInt();
        if(opln==2){
        System.out.println("Gracias por usar nuestros servicios, vuelva pronto");
        System.exit(0);
        }
                 
        System.out.println("Inserte su Rol En la Universidad ");
        System.out.println("(1)Estudiante  (2)Profesor   (3)Personal Admin   ");       
        op = entrada.nextInt();
		switch(op){
		case 1: 
			menuEstudiante();
			break;
		case 2: 
			menuDocente();
			break;
		case 3:
			menuAdmin();
			break;
		default :
			System.out.println("Opcion no valida");
		
		}
		System.out.println("Desea salirse  ?");
		System.out.println("(1)Si  (2)No");
		op = entrada.nextInt();
		if (op == 1)
			System.exit(0);
		}while(op != 1);
		
		
	}
	
	
	public static int menuEstudiante()
	{
		BDInfoEstudiante info =new BDInfoEstudiante();
		 Scanner leer = new Scanner(System.in);
		 int opc;
		System.out.println("MENU\n");
		System.out.println("1. Darse de Alta");
		System.out.println("2. Darse de Baja");
		System.out.println("3. Modificar");
		System.out.println("4. Imprimir");
		System.out.println("5. Listar");
		
		System.out.println("Ingrese la opcion deseada");
		opc=leer.nextInt();
		switch(opc) {
		case 1:
			info.darDeAlta();
			break;
		case 2:
			info.darDeBaja();
			break;
		case 3:
			info.modificar();
			break;
		case 4:
			info.imprimr();
			break;
		case 5:
			info.listar();
		default :
			System.out.println("Opcion no valida");
		}
		return opc;
	}
	public static int menuDocente()
	{
		BDInfoDocente info =new BDInfoDocente();
		 Scanner leer = new Scanner(System.in);
		 int opc;
		System.out.println("MENU\n");
		System.out.println("1. Darse de Alta");
		System.out.println("2. Darse de Baja");
		System.out.println("3. Modificar");
                System.out.println("4. Imprimir");
                System.out.println("5. Listar");
		
		System.out.println("Ingrese la opcion deseada");
		opc=leer.nextInt();
		switch(opc) {
		case 1:
			info.darDeAlta();
			break;
		case 2:
			info.darDeBaja();
			break;
		case 3:
			info.modificar();
			break;
		case 4:
			info.imprimr();
			break;
		case 5:
			info.listar();
		default :
			System.out.println("Opcion no valida");
		}
		return opc;
	}
	public static int menuAdmin()
	{
		BDInfoAdmin info =new BDInfoAdmin();
		 Scanner leer = new Scanner(System.in);
		 int opc;
		System.out.println("MENU\n");
		System.out.println("1. Darse de Alta");
		System.out.println("2. Darse de Baja");
		System.out.println("3. Modificar");
                System.out.println("4. Imprimir");
                System.out.println("5. Listar");
		
		System.out.println("Ingrese la opcion deseada");
		opc=leer.nextInt();
		switch(opc) {
		case 1:
			info.darDeAlta();
			break;
		case 2:
			info.darDeBaja();
			break;
		case 3:
			info.modificar();
			break;
		case 4:
			info.imprimr();
			break;

		case 5:
			info.listar();
		default :
			System.out.println("Opcion no valida");
		}
		return opc;
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	       
	    }
	}

public static void saludar()
{
	System.out.println("*********************");
	System.out.println("*********************");


}
}
