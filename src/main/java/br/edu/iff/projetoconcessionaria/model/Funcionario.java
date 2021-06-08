
package br.edu.iff.projetoconcessionaria.model;

import java.util.List;


public class Funcionario {
    
    private String funcao;
    private String senha;
    
    private List<Reserva> reservas;


    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    
}
