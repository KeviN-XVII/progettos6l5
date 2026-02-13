package kevinquarta.progettos6l5.repositories;


import kevinquarta.progettos6l5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, Long> {
}
