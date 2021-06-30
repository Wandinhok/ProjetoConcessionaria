
package br.edu.iff.projetoconcessionaria.repository;

import br.edu.iff.projetoconcessionaria.model.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long>{
    
    
    
    
}
