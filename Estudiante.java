package UniversidadBD;

public class Estudiante extends Persona{
	String curso;
	String codigo;
	
	
	public Estudiante(String nombre, String apellido, String Id, String EstadoCivil, String curso, String codigo) {
		super(nombre, apellido, Id, EstadoCivil);
		this.curso = curso;
		this.codigo = codigo;
	}
	
	@Override
	public void imprmir() {
		System.out.println("Identificacion\t Nombre \t Apellido \t Estado Civil \tCurso \t Codigo");
		System.out.println(this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.curso +  "\t" + this.codigo);
	}
	public void matricular(String nuevoCurso) {
		System.out.format(" El anterior curso era %s \n", this.curso);
		this.curso = nuevoCurso;
		System.out.format(" El nuevo curso es %s \n", this.curso);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.Id + "\t" + this.nombre + "\t" + this.apellido + "\t" + this.EstadoCivil+ "\t" + this.curso +  "\t" + this.codigo ;
	}

	

}
