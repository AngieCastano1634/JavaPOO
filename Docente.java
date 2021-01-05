package UniversidadBD;

import java.util.Scanner;

public class Docente extends Persona implements Empleado{
	private String oficina;
	private String aniodeIncorporacion;
	private String carrera;
	
	public Docente(String nombre, String apellido, String Id, String EstadoCivil, String oficina, String anio, String carrera) {
		super(nombre, apellido, Id, EstadoCivil);
		this.oficina = oficina;
		this.aniodeIncorporacion = anio;
		this.carrera = carrera;
	}
	
	@Override
	public void imprmir() {
		System.out.println("Identificacion\t Nombre \t Apellido \t Estado Civil \t Oficina \tAño \tCarrera");
		System.out.println(this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.oficina +  "\t" + this.aniodeIncorporacion + "\t" + this.carrera);
	}
	
	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getAniodeIncorporacion() {
		return aniodeIncorporacion;
	}

	public void setAniodeIncorporacion(String aniodeIncorporacion) {
		this.aniodeIncorporacion = aniodeIncorporacion;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public void modificarOficina() {
		// TODO Auto-generated method stub}
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
		String nuevaCarrera;
		Scanner leer1 = new Scanner(System.in);
		if (this.getId().equals(Id))
				{	
					System.out.println(" Carrera Anterior: "+ this.getCarrera());
					System.out.println("¿Cual es su nueva Carrera?");
					nuevaCarrera= leer1.nextLine();
					this.setOficina(nuevaCarrera);
					System.out.println("Carrera Guardada : "+this.getCarrera());
				}
	}
	@Override
	public String toString() {
		return this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.oficina +  "\t" + this.aniodeIncorporacion + "\t" + this.carrera ;
	}
	
	
}
