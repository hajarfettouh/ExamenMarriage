package ExamenMariage.demo.repositories;

import ExamenMariage.demo.entities.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<Invite,Long> {
}
