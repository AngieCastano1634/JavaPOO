package calcularResistecias;

public class Resistencia {
	private double banda1, banda2, banda3, banda4, banda5;
	
	Resistencia(double Banda1,double Banda2, double Banda3, double Banda4, double Banda5 ){
		this.banda1 = Banda1;
		this.banda2 = Banda2;
		this.banda3 = Banda3;
		this.banda4 = Banda4;
		this.banda5 = Banda5;
	}
	
	public double primerasTresBandas() {
		return this.banda1 * 100 + this.banda2 * 10 + this.banda3;
	}
	public double FactorMultiplicador() {
		return potencia(10, this.banda4);
	}
	public static double potencia(double base, double exponente) {
		double resultado = 1;
		int i  = 0;
		for (i = 0; i < exponente; i++)
		{
			resultado *= base;
		}
		return resultado;
	}
	public double resistenciaSinCalcularTolerancia() {
		return primerasTresBandas() * FactorMultiplicador();
	}
	public double ResistenciaConToleranciaPositiva()
	{
		double tolerancia = resistenciaSinCalcularTolerancia() * this.banda5;
		return resistenciaSinCalcularTolerancia() + tolerancia;
	}
	public double ResistenciaConToleranciaNegativa()
	{
		double tolerancia = resistenciaSinCalcularTolerancia() * this.banda5;
		return resistenciaSinCalcularTolerancia() - tolerancia;
	}

	public double getBanda1() {
		return banda1;
	}

	public void setBanda1(double banda1) {
		this.banda1 = banda1;
	}

	public double getBanda2() {
		return banda2;
	}

	public void setBanda2(double banda2) {
		this.banda2 = banda2;
	}

	public double getBanda3() {
		return banda3;
	}

	public void setBanda3(double banda3) {
		this.banda3 = banda3;
	}

	public double getBanda4() {
		return banda4;
	}

	public void setBanda4(double banda4) {
		this.banda4 = banda4;
	}

	public double getBanda5() {
		return banda5;
	}

	public void setBanda5(double banda5) {
		this.banda5 = banda5;
	}
	
}