package UniversidadBD;

import java.util.Scanner;

public class PersonalAdmin extends Persona implements Empleado{
	private String anioDeIncorporacion;
	private String oficina;
	private String seccion;

	public PersonalAdmin(String nombre, String apellido, String Id, String EstadoCivil, String anio, String oficina, String seccion) {
		super(nombre, apellido, Id, EstadoCivil);
		this.anioDeIncorporacion = anio;
		this.oficina = oficina;
		this.seccion = seccion;
	}
	@Override
	public void imprmir() {
		System.out.println("Identificacion\t Nombre \t Apellido \t Estado Civil \t Oficina \tAño \tSeccion");
		System.out.println(this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.oficina +  "\t" + this.anioDeIncorporacion + "\t" + this.seccion);
	}
	public String getAnioDeIncorporacion() {
		return anioDeIncorporacion;
	}
	public void setAnioDeIncorporacion(String anioDeIncorporacion) {
		this.anioDeIncorporacion = anioDeIncorporacion;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	@Override
	public void modificarOficina() {
		// TODO Auto-generated method stub
		String nuevaOficina;
		Scanner leer1 = new Scanner(System.in);
		if (this.getId().equals(Id))
				{	
					System.out.println(" Oficina Anterior: "+ this.getOficina());
					System.out.println("Cual es su nueva Oficina?");
					nuevaOficina= leer1.nextLine();
					this.setOficina(nuevaOficina);
					System.out.println("Oficina Guardada : "+this.getOficina());
				}
		}
	@Override
	public void cambiar() {
		// TODO Auto-generated method stub
		String nuevaSeccion;
		Scanner leer1 = new Scanner(System.in);
		if (this.getId().equals(Id))
				{	
					System.out.println(" Sección Anterior: "+ this.getSeccion());
					System.out.println("¿Cual es su nueva Sección?");
					nuevaSeccion= leer1.nextLine();
					this.setOficina(nuevaSeccion);
					System.out.println("Sección Guardada : "+this.getSeccion());
				}
	}
	@Override
	public String toString() {
		return this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.oficina +  "\t" + this.anioDeIncorporacion + "\t" + this.seccion ;
	}

}
