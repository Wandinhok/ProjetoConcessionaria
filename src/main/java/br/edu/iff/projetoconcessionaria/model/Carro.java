
package br.edu.iff.projetoconcessionaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Carro implements Serializable {
    
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(length = 7, nullable = false, unique = true)
     @NotBlank(message="Placa obrigatória.")
     @Length(max = 8, min = 7 , message = "Placa deve ter 8 ou 7 caracteres. Ex: (AAA-AAAA) ou (AAAAAAA)")
     private String placa;
     @Column(length = 17, nullable = false, unique = true)
     @NotBlank(message="Chassi obrigatório.")
     @Length(max = 17, min = 17 , message = "Chassi deve ter exatamente 17 caracteres.")
     private String chassi;
     @Column(length = 11, nullable = false, unique = true)
     @NotBlank(message="Renavam obrigatório.")
     @Length(max = 11, min = 11 , message = "Renavam deve ter exatamente 11 caracteres.")
     private String renavam;
     @Column(length = 7, nullable = false)
     @NotBlank(message="Km obrigatório.")
     @Length(max = 7, min = 1 , message = "Km deve ter no máximo 7 caracteres.")
     private String km;
     @Column(length = 25, nullable = false)
     @NotBlank(message="Modelo obrigatório.")
     @Length(max = 25, message = "Modelo deve ter no máximo 25 caracteres.")
     private String modelo;
     @Column(length = 15, nullable = false)
     @NotBlank(message="Cor obrigatória.")
     @Length(max = 15 , message = "Cor deve ter no máximo 15 caracteres.")
     private String cor;
     @Column(length = 17, nullable = false)
     @Enumerated(EnumType.STRING)
     @NotNull(message = "Tipo de combustível obrigatório")
     private TipoCombustivelEnum tipo;
     @Column(length = 4, nullable = false)
     @NotBlank(message="Ano obrigatório.")
     @Length(max = 4 , min = 4 , message = "Ano deve ter exatamente 4 caracteres.")
     private int ano;
     
     @ManyToMany(mappedBy = "carros")
     @JsonIgnore
     private List<Reserva> reservas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    


   
    
}
