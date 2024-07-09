/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author Jal
 */
public class DAO<T> {
    
    private static Conexao conn;

    public DAO(){
        conn = new Conexao();
    }
    
    public void inserir(T obj) throws SQLException{
        //limparTabela();
        String sql = "INSERT INTO";
        PreparedStatement st;

        sql += " objeto (nome, distancia, velocidade, tamanho, risco, dataaprox) VALUES (?, ?, ?, ?, ?, ?);";
        Objeto a = (Objeto) obj;

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, a.getNome());
            st.setFloat(2, a.getDistancia());
            st.setFloat(3, a.getVelocidade());
            st.setFloat(4, a.getTamanho());
            st.setString(5, a.getRisco());
            st.setString(6, a.getDataAprox());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Problema na conexão");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public static ArrayList<Objeto> consultar(String ordem) throws SQLException, ClassNotFoundException {
        ArrayList<Objeto> ret = new ArrayList<>();
        String sql = "SELECT * FROM objeto ORDER BY " + ordem + ";"; //consulta na ordem

        PreparedStatement st;
        ResultSet rs;
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        
        while (rs.next()) {//enquanto não tiver chegado ao final do result set
            Objeto a = new Objeto();
            a.setNome(rs.getString("nome"));
            a.setDistancia(rs.getFloat("distancia"));
            a.setVelocidade(rs.getFloat("velocidade"));
            a.setTamanho(rs.getFloat("tamanho"));
            a.setRisco(rs.getString("risco"));
            a.setDataAprox(rs.getString("dataaprox"));
            ret.add((Objeto) a);
        }
            
        rs.close();
        st.close();
        return ret;
    }
    
    public static ArrayList<Objeto> consultarGrafico() throws SQLException{
        ArrayList<Objeto> ret = new ArrayList<>();
        String sql = "SELECT dataaprox, COUNT(dataaprox) FROM objeto GROUP BY dataaprox ORDER BY dataaprox ASC;"; //consulta na ordem

        PreparedStatement st;
        ResultSet rs;
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        
        while (rs.next()) {//enquanto não tiver chegado ao final do result set
            Objeto a = new Objeto();
            a.setDataAprox(rs.getString("dataaprox"));
            a.setQnt(rs.getInt("COUNT(dataaprox)"));
            ret.add((Objeto) a);
        }
            
        rs.close();
        st.close();
        return ret;
    }
    
    public static void limparTabela(){
        String sql = "truncate objeto;";
        PreparedStatement st;
        
        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            System.out.println("N limpou");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
