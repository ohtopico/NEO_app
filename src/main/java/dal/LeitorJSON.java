/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static java.lang.Float.valueOf;
import java.sql.SQLException;
import java.util.ArrayList;
import model.APOD;
import model.Objeto;

/**
 *
 * @author Jal
 */
public class LeitorJSON {
    
    public static ArrayList<Objeto> Leitor(APOD apod) throws SQLException, ClassNotFoundException{
        String strNEO = apod.near_earth_objects.toString();
        String[] str = strNEO.split(",");
        ArrayList<Objeto> ListaObjetos = new ArrayList<Objeto>();
        Objeto ListaAux = new Objeto();
        DAO<Objeto> dao = new DAO<>();
        
        for (String word : str){
            //System.out.println(word);
            if (word.contains("name=") && !(word.contains("2024-07-07"))){
                ListaAux.setNome(word.replace("name=",""));
               
            }else if(word.contains("estimated_diameter={kilometers={estimated_diameter_min=")){
                ListaAux.setTamanho(Float.parseFloat(word.replace("estimated_diameter={kilometers={estimated_diameter_min=","")));
                  
            }else if(word.contains("is_potentially_hazardous_asteroid=")){
                ListaAux.setRisco(word.replace("is_potentially_hazardous_asteroid=",""));
                
            }else if(word.contains("close_approach_data=[{close_approach_date=")){
                ListaAux.setDataAprox(word.replace("close_approach_data=[{close_approach_date=",""));
        
            }else if(word.contains("kilometers_per_hour=")){
                ListaAux.setVelocidade(Float.parseFloat(word.replace("kilometers_per_hour=","")));
                
            }else if(word.contains("kilometers=")){
                ListaAux.setDistancia(Float.parseFloat(word.replace("kilometers=","")));
                ListaObjetos.add(ListaAux);
                
                dao.inserir(ListaAux);
                ListaAux = new Objeto();
                
            }
        }
       
            //System.out.println(ListaObjetos.get(0).getNome());
            //System.out.println(ListaObjetos.get(1).getNome());
            
        return ListaObjetos;
    }
}
