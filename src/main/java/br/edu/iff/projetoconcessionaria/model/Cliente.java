
package br.edu.iff.projetoconcessionaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente extends Pessoa {
    @Column(length = 200)
    @Length(max = 200, message = "Documentos devem ter no máximo 200 caracteres.")
    private String documentos; 
    @Column(nullable = false, length = 10)
    @NotBlank(message="Data de nascimento obrigatória.")
    private Date dt_nascimento;
    @Column(nullable = false, length = 2)
    @NotBlank(message="Habilitação obrigatória.")
    @Length(max = 2, message = "Habilitaçãp deve ter no máximo 2 caracteres")
    private String habilitacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas = new ArrayList<>();

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
