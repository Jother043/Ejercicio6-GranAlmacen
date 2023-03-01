
public class GranAlmacen {

	private static final int MAXIMO_DE_CAJAS = 20;
	private static int numeroDeClientes=0;
	private Caja cajas[];
	
	
	public GranAlmacen() {
		
		cajas=new Caja[MAXIMO_DE_CAJAS];

		inicializarCajas();
	}

	private void inicializarCajas() {
		
		int i;
		
		for (i=0; i<cajas.length; i++){
			cajas[i]=new Caja((i+1));
		}
	}
	
	
	
	public void abrirCaja(int numeroCaja) throws CajaException{
		if(numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS){
			throw new CajaException("La caja que has introducido no existe. ");
		}
		cajas[numeroCaja - 1].abrirCaja();
	}
	
	public void cerrarCaja(int numeroCaja) throws CajaException{
		if(numeroCaja <= 0 || numeroCaja > MAXIMO_DE_CAJAS){
			throw new CajaException("La caja que has introducido no existe. ");
		}
		cajas[numeroCaja - 1].cerrarCaja();
	
	}
	
	public String nuevoCliente() throws CajaException{
		int numCajaMenosClientes = cajaMenosCliente();
		cajas[numCajaMenosClientes - 1].agregarNuevoClienteCaja(++numeroDeClientes);
		return "Es usted el cliente: " + numeroDeClientes + " su caja asignada es la caja: " + numCajaMenosClientes;
	}

	public int atenderCliente(int numeroCaja) throws CajaException{


		return numeroCaja;
	}
	
	public String toString(){

		return null;
	}

	/** 
	 * 
	 * @return Devuelve el número de caja que tiene menos clientes
	 * @throws CajaException Si todas las cajas están cerradas
	 */
	
	private int cajaMenosCliente() throws CajaException {
		int numCliente = Integer.MAX_VALUE;
		int numCaja = 0;
		for(int i = 0;i < cajas.length; i++ ){
			if(cajas[i].isEstaAbierta() && cajas[i].tamannoColaCliente() < numCliente){
				numCaja = cajas[i].getNumeroCaja();
				numCliente = cajas[i].tamannoColaCliente();
			}
		}
		if(numCaja == 0){
			throw new CajaException("No hay cajas disponibles.");
		}
		return numCaja;
	}

	
}
