package UniversidadBD;

import java.util.ArrayList;
import java.util.Scanner;


public class BDInfoEstudiante implements BD{

	public static  ArrayList <Estudiante> ListaEstudiante = new ArrayList <Estudiante> ();
	@Override
	public void darDeAlta() {
		// TODO Auto-generated method stub
		String id, nombre, apellido, EstadoCivil, curso, codigo;
		
		 Scanner leer = new Scanner(System.in);
		 
		 System.out.print("Ingrese identificación: ");
		 id = leer.nextLine();
		
		System.out.print("Ingrese nombre: ");
		nombre = leer.nextLine();
		
		System.out.print("Ingrese apellido: ");
		apellido = leer.nextLine();
		
		System.out.print("Ingrese estado civil: ");
		EstadoCivil = leer.nextLine();
		
		System.out.print("Ingrese curso: ");
		curso = leer.nextLine();
		
		System.out.print("Ingrese codigo: ");
		codigo = leer.nextLine();

		Estudiante objEst = new Estudiante(id, nombre, apellido, EstadoCivil, curso, codigo);
		ListaEstudiante.add(objEst);
	}

	@Override
	public void darDeBaja() {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese identificación: ");
		String id;
		id = leer.nextLine();
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(id))
			{
				ListaEstudiante.remove(ListaEstudiante.indexOf(i));
				i = null;	
			}
		}
	System.out.println("Identificación no encontrada");
	}

	@Override
	public void imprimr() {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese identificación: ");
		String id;
		id = leer.nextLine();
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(id))
			{
				i.imprmir();	
			}
		}
	System.out.println("Identificación no encontrada");
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		int opc;
		String id;
		String elemento;
		System.out.println("Inserte elemento a modificar ");
        System.out.println(" (1)Nombre   (2)Apellido (3) Estado Civil (4)Matricularse en diferente Curso");
        Scanner entrada = new Scanner (System.in);
        opc = entrada.nextInt();
        System.out.print("Ingrese identificacion: ");
		id = entrada.next();
        switch(opc)
        {
        case 1:
        	System.out.println("Ingrese Nombre: ");
    		elemento = entrada.next();
        	modificarNombre(id, elemento);
        	break;
        case 2:
        	System.out.println("Ingrese Apellido: ");
    		elemento = entrada.next();
        	modificarApellido(id, elemento);
        	break;
        case 3:
        	System.out.println("Ingrese Estado Civil: ");
    		elemento = entrada.next();
        	modificarEstadoCivil(id, elemento);
        	break;
        case 4:
        	System.out.println("Ingrese Curso: ");
    		elemento = entrada.next();
        	modificarCurso(id, elemento);
        	break;
        default:
        	System.out.print("Opción no válida\n");
        }
	}
	public static void modificarNombre(String identificacion, String nuevoNombre) { 
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(identificacion))
			{	
				System.out.println("Nombre anterior: "+i.getNombre());
				i.setNombre(nuevoNombre);
				
				System.out.println("Nombre modificado: "+i.getNombre());
				return;
			}
		}
		System.out.println("identificación no encontrada");
	}
	public static void modificarApellido(String identificacion, String nuevoApellido) { 
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(identificacion))
			{	
				System.out.println("Apellido anterior: "+i.getApellido());
				i.setApellido(nuevoApellido);
				
				System.out.println("Apellido modificado: "+i.getApellido());
				return;
			}
		}
		System.out.println("identificación no encontrada");
	}
	public static void modificarEstadoCivil(String identificacion, String nuevoEstadoCivil) { 
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(identificacion))
			{	
				System.out.println("EstadoCivil anterior: "+i.getEstadoCivil());
				i.setEstadoCivil(nuevoEstadoCivil);
				
				System.out.println("EstadoCivil modificado: "+i.getEstadoCivil());
				return;
			}
		}
		System.out.println("identificación no encontrada");
	}
	
	public static void modificarCurso(String identificacion, String nuevoCurso) { 
		for ( Estudiante i : ListaEstudiante ) {
			
			if (i.getId().equals(identificacion))
			{	
				i.matricular(nuevoCurso);
			}
		}
		System.out.println("identificación no encontrada");
	}
	@Override
	public void listar() {
		// TODO Auto-generated method stub
			System.out.println("Identificacion\t Nombre \t Apellido \t Estado Civil \tCurso \t Codigo");
			System.out.println("------------------------------------------------------------");
			
			for ( Estudiante i : ListaEstudiante )
				System.out.println(i.toString());
		}
}
