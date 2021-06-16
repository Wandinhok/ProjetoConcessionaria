
package br.edu.iff.projetoconcessionaria.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    @Column(length = 200)
    private String documentos; 
    @Column(nullable = false, length = 10)
    private Date dt_nascimento;
    @Column(nullable = false, length = 2)
    private String habilitacao;
    
    private List<Reserva> reservas;

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    
    
    
    
}