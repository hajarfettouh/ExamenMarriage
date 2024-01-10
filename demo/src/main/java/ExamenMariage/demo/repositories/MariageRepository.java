package ExamenMariage.demo.repositories;
import ExamenMariage.demo.entities.Mariage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MariageRepository extends JpaRepository<Mariage,Long> {
}
