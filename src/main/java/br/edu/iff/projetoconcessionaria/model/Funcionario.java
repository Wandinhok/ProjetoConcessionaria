
package br.edu.iff.projetoconcessionaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Pessoa {
    
    @Column(nullable = false, length = 50)
    private String funcao;
    @Column(nullable = false)
    private String senha;
    
    @JsonBackReference
    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas = new ArrayList<>();


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
