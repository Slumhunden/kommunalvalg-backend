package exam.kommunalvalg.repository;

import exam.kommunalvalg.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
