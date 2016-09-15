
//  @ Author : pabloarellano
//
//

public class Avion {
	private String fabricante, modelo;
	private int alcance;
	
		/**
	 * @param nombre
	 * @param nota
	 */
	public Avion(String fabricante, String modelo, int alcance) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.alcance = alcance;
	}

	/**
	 * 
	 */
	public Avion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nombre
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * @return de modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return de alcance
	 */
	public int getAlcance() {
		return alcance;
	}

	/**
	 * @param de alcance
	 */
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fabricante: "+ fabricante +" Modelo: "+ modelo +" Alcance: "+ alcance;
	}
	

}
