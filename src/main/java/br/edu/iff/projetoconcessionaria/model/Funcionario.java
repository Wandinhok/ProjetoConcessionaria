
package br.edu.iff.projetoconcessionaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
public class Funcionario extends Pessoa {
    
    @Column(nullable = false, length = 50)
    @NotBlank(message="Função obrigatória.")
    @Length(max = 50, message = "Função deve ter no máximo 150 caracteres")
    private String funcao;
    

    @Column(nullable = false)
    @NotBlank(message="Senha obrigatória.")
    @Length(min = 8, message = "Senha deve ter no mínimo 150 caracteres")
    private String senha;
    
    @JsonIgnore
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
