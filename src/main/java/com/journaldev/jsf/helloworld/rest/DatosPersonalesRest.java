package com.journaldev.jsf.helloworld.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.jsf.helloworld.models.DatosPersonales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class DatosPersonalesRest {

    private static final Logger log = LoggerFactory.getLogger(DatosPersonalesRest.class);


    public String urlBAse = "http://localhost:8085/api/datos-personales/";

    public List<DatosPersonales> getDatosPersonales() {
        List<DatosPersonales> lstDatosPersonales = null;
        try {
            URL url = new URL(urlBAse);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String respuesta;

            while ((respuesta = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                lstDatosPersonales = mapper.readValue(respuesta, new TypeReference<List<DatosPersonales>>(){});
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lstDatosPersonales;
    }

    public DatosPersonales updateDatos (DatosPersonales datosPersonales) throws IOException {
        URL url = new URL(urlBAse+datosPersonales.getId());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(datosPersonales);
        osw.write(jsonString);
        osw.flush();
        osw.close();
        log.error("Error: {}",connection.getResponseCode());

        return datosPersonales;
    }

    public void deleteDatos(Long id) throws IOException {
        URL url = new URL(urlBAse+id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.flush();
        osw.close();
        log.error("Error: {}", connection.getResponseCode());

    }
    public DatosPersonales saveDatos (DatosPersonales datosPersonales) throws IOException {
        URL url = new URL(urlBAse);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(datosPersonales);
        osw.write(jsonString);
        osw.flush();
        osw.close();
        log.error("Error: {}",connection.getResponseCode());

        return datosPersonales;
    }
}
