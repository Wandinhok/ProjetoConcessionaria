
package br.edu.iff.projetoconcessionaria.repository;

import br.edu.iff.projetoconcessionaria.model.Reserva;
import java.util.Calendar;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    @Query("SELECT DISTINCT (r) FROM Concessionaria con JOIN con.carros c JOIN c.reservas r WHERE con.id = :concessionariaId")
    
    public List<Reserva> findByReservasByHotel(@Param("concessionariaId") Long concessionariaId );
    
    public List<Reserva> findByFuncionarioId(Long funcionarioId, Pageable page);
    
    public List<Reserva> findByClienteId(Long funcionarioId, Pageable page);
    
    public List<Reserva> findByClienteIdAndFuncionarioId(Long ClienteId, Long funcionarioId, Pageable page);
    
    @Query("SELECT DISTINCT (r) FROM Reserva r WHERE (r.inicio BETWEEN :inicio AND :termino) OR (r.termino BETWEEN :inicio AND :termino) ")
    public List<Reserva> findByReservasEntreDatas(Calendar inicio, Calendar termino);
}
