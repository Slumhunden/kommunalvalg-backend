package exam.kommunalvalg;

import exam.kommunalvalg.entity.Candidate;
import exam.kommunalvalg.entity.Party;
import exam.kommunalvalg.repository.CandidateRepository;
import exam.kommunalvalg.repository.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KommunalvalgApplication {

    public static void main(String[] args) {
        SpringApplication.run(KommunalvalgApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(PartyRepository partyRepository, CandidateRepository candidateRepository){
        return args -> {
            Party p1 = new Party();
            p1.setName("A");
            partyRepository.save(p1);
            Party p2 = new Party();
            p2.setName("B");
            partyRepository.save(p2);

            Candidate c1 = new Candidate();
            c1.setName("C1");
            c1.setParty(p1);
            candidateRepository.save(c1);
            Candidate c2 = new Candidate();
            c2.setName("C2");
            c2.setParty(p1);
            candidateRepository.save(c2);
        };
    }
}
