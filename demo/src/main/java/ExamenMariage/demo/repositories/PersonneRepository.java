package ExamenMariage.demo.repositories;

import ExamenMariage.demo.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
