package exam.kommunalvalg.repository;

import exam.kommunalvalg.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
}
