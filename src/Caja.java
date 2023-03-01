
import java.util.LinkedList;


public class Caja{

	private int numeroCaja;
	private boolean estaAbierta;
	private LinkedList<Integer>colaCliente;
	
	public Caja(int numeroCaja) {

		this.numeroCaja=numeroCaja;
		estaAbierta=false;
		colaCliente=new LinkedList<Integer>();
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	private void setEstaAbierta(boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}
	
	public void abrirCaja() throws CajaException {
		if(this.estaAbierta){
			throw new CajaException("La caja ya está abierta. ");
		}else{
			setEstaAbierta(true);
		}
	}

	public void cerrarCaja() throws CajaException {
		if(this.estaAbierta && colaCliente.size() == 0){
			setEstaAbierta(false);
		}else{
			throw new CajaException("La caja ya estaba cerrada. ");
		}
	}
	
	public int tamannoColaCliente(){
		
		return colaCliente.size();
	}
	
	public void agregarNuevoClienteCaja(Integer cliente) throws CajaException{

		if(!estaAbierta){
			throw new CajaException("La caja está cerrada");
		}
		colaCliente.add(cliente);
	}
	
	public Integer atenderCliente() throws CajaException {


		return null;
	}
	
	public String toString() {

		return null;
	}

	

	
	
	
	
	
}
