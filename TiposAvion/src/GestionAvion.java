/**
 * @author pabloare
 *
 */
public class GestionAvion {
	private Avion[] arregloAvion;
	private int cantidadAsignada = 10, x; //cantidad de aviones ingresaoas en el arreglo
	/**
	 * 
	 */

	/**
	 * Ingresar los aviones al arreglo
	 * @param fabricante
	 * @param modelo
	 * @param modelo
	 */
	public void llenarAvion(String fabricante, String modelo, int alcance){
		Avion ingresoTemporal = new Avion(fabricante, modelo, alcance);
		if (cantidadAsignada<arregloAvion.length){
			arregloAvion[cantidadAsignada] = ingresoTemporal;
			cantidadAsignada++;
			
		}
	}
	
		public GestionAvion() {
		arregloAvion = new Avion[10];
		cantidadAsignada = 0;		
	}

	public String toString(int x) {
		return arregloAvion[x-1].toString();
	}
}
