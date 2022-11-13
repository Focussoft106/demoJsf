package com.journaldev.jsf.helloworld.mb;

import com.journaldev.jsf.helloworld.models.DatosPersonales;
import com.journaldev.jsf.helloworld.service.DatosPersonalesService;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean(name = "datosPersonalesView")
@SessionScoped
public class DatosPersonalesView implements Serializable {

	@Inject
	private DatosPersonalesService datosPersonalesService;
	private List<DatosPersonales> datosPersonalesList;

	private DatosPersonales datosPersonales = new DatosPersonales();

	@PostConstruct
	public void init(){
		datosPersonalesList =  datosPersonalesService.getDatos();
	}
	public List<DatosPersonales> getDatosPersonalesList() {
		return datosPersonalesList;
	}

	public void setDatosPersonalesList(List<DatosPersonales> datosPersonalesList) {
		this.datosPersonalesList = datosPersonalesList;
	}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public void atualizar() throws IOException {
		datosPersonalesService.updateDAtosPersonales(datosPersonales);
	}

	public void remover() throws IOException {
		datosPersonalesService.deleteDatosPersonales(datosPersonales.getId());
		init();
	}

	public void guardar() throws IOException {
		datosPersonalesService.saveDatosPersonales(datosPersonales);
		init();
		limpar();

	}

	public void limpar() {
		datosPersonales = new DatosPersonales();
	}

}
