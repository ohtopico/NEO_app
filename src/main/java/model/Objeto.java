/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jal
 */
public class Objeto {
    private String nome;
    private float distancia;
    private float velocidade;
    private float tamanho;
    private String risco;
    private String dataaprox;
    private int qnt; //auxiliar para consultas
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public float getDistancia(){
        return distancia;
    }
    
    public void setDistancia(float distancia){
        this.distancia = distancia;
    }
    
    public float getVelocidade(){
        return velocidade;
    }
    
    public void setVelocidade(float velocidade){
        this.velocidade = velocidade;
    }
    
    public float getTamanho(){
        return tamanho;
    }
    
    public void setTamanho(float tamanho){
        this.tamanho = tamanho;
    }
    
    public String getRisco(){
        return risco;
    }
    
    public void setRisco(String risco){
        this.risco = risco;
    }
    
    public String getDataAprox(){
        return dataaprox;
    }
    
    public void setDataAprox(String dataaprox){
        this.dataaprox = dataaprox;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
    
       public int setQnt() {
        return qnt;
    }
}
