package com.journaldev.jsf.helloworld.service;

import com.journaldev.jsf.helloworld.models.DatosPersonales;
import com.journaldev.jsf.helloworld.rest.DatosPersonalesRest;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named
@RequestScoped
public class DatosPersonalesService {
    public List<DatosPersonales> getDatos(){
        DatosPersonalesRest datosPersonalesRest = new DatosPersonalesRest();
        return datosPersonalesRest.getDatosPersonales();
    }

    public DatosPersonales updateDAtosPersonales(DatosPersonales datosPersonales) throws IOException {
        DatosPersonalesRest datosPersonalesRest = new DatosPersonalesRest();
        return datosPersonalesRest.updateDatos(datosPersonales);
    }

    public void deleteDatosPersonales(Long id) throws IOException {
        DatosPersonalesRest datosPersonalesRest = new DatosPersonalesRest();
        datosPersonalesRest.deleteDatos(id);
    }

    public DatosPersonales saveDatosPersonales(DatosPersonales datosPersonales) throws IOException {
        DatosPersonalesRest datosPersonalesRest = new DatosPersonalesRest();
        return datosPersonalesRest.saveDatos(datosPersonales);
    }
}
