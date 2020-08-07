package gestor;

import java.time.LocalDate;

import dao.CamionDao;
import dao.CamionDaoPostgreSQL;
import dominio.Camion;
import exepciones.CampoVacioException;
import gui.PanelCamionDarAlta;
import servicios.CamionServicio;

public class GestorCamion {
	
	
	public void altaCamion(String patente, String modelo, Double kmrecorridos, Double costoporkm, 
			Double costoporhora, LocalDate fechadecompra) {
			
			//Integer ultimoIdCamion = camionDao.getUltimoId();

			//Campos obligatorios: Todos	
			Camion c = new Camion(1,patente,modelo,kmrecorridos,costoporkm,costoporhora,fechadecompra); //En el campo de id tiene el valor 1 por que la bd lo maneja serial
			try {
				this.verificarDatos(c);
			} catch (CampoVacioException e) {
				e.printStackTrace();
			}
			CamionServicio cs = new CamionServicio();
			
			cs.altaCamion(c);
		
		
	}
	
	public void updateCamion(Integer id, String patente, String modelo, Double kmrecorridos, Double costoporkm, 
			Double costoporhora, LocalDate fechadecompra) {
		
			Camion c = new Camion(id,patente,modelo,kmrecorridos,costoporkm,costoporhora,fechadecompra); 
			try {
				this.verificarDatos(c);
			} catch (CampoVacioException e) {
				e.printStackTrace();
			}
			CamionServicio cs = new CamionServicio();
		
			cs.updateCamion(c);
	
		
		 	
	}
	
	public void bajaCamion(Integer id) {
		
		Camion c = new Camion(id);
		CamionServicio cs = new CamionServicio();

		cs.bajaCamion(c);
		
		
	}
	
	public void recuperarCamion(Integer id) {
		
		Camion c = new Camion(id);
		CamionServicio cs = new CamionServicio();

		cs.bajaCamion(c);
		
		
	}
	
	
	
	public Camion recuperarCamion() {
			return null;
	}
	
	
	public void verificarDatos(Camion c) throws CampoVacioException {
		if(c.getPatente().length() == 0) throw new CampoVacioException("patente");	
		if(c.getModelo().length() == 0) throw new CampoVacioException("modelo");	
		
		
		/* No creo que sea necesario, el constructor ya romperia
		if(c.getKmRecorridos() == null) throw new CampoVacioException("km recorridos");	
		if(c.getCostoPorKm() == null) throw new CampoVacioException("costo por km");	
		if(c.getCostoPorHora() == null) throw new CampoVacioException("costo por hora");	
		if(c.getFechaDeCompra() == null) throw new CampoVacioException("fecha de compra");	
		*/
		
	}
	
}
		
		
	
