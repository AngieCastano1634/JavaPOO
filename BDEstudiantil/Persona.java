package UniversidadBD;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected String Id;
	protected String EstadoCivil;
	
	public Persona(String nombre, String apellido, String Id, String EstadoCivil ){
		this.nombre = nombre;
		this.apellido = apellido;
		this.Id = Id;
		this.EstadoCivil = EstadoCivil;
	}
	public abstract void imprmir();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getEstadoCivil() {
		return EstadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}
	
}
