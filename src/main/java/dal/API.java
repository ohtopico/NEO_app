/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.APOD;
import view.FrmProjeto;

/**
 *
 * @author Jal
 */
public class API {
    
        public static APOD chamar(String dataInicio, String dataFim){
        String apiKey = "gIUp3iD5UgMZHfW4QlufvfZUlk4Sj1WlZwhEiSet";
        String apiUrl = "https://api.nasa.gov/neo/rest/v1/feed?start_date=" + dataInicio + "&end_date=" + dataFim + "&api_key=" + apiKey;
        // Create a neat value object to hold the URL
        URL url;
        try {
            url = new URL(apiUrl);
            HttpURLConnection connection;
        
            try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            // Faz o request
            InputStream responseStream = connection.getInputStream();

            // Manually converting the response body InputStream to APOD using Jackson
            ObjectMapper mapper = new ObjectMapper();
            APOD apod = mapper.readValue(responseStream, APOD.class);

            // Resposta
            System.out.println("Elementos achados: " + apod.element_count);
            System.out.println(apod.near_earth_objects);
            return apod;
            
        } catch (IOException ex) {
            Logger.getLogger(FrmProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return null;
    }
    
    
}
