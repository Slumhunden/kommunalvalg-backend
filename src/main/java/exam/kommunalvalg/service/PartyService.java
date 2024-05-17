package exam.kommunalvalg.service;

import exam.kommunalvalg.entity.Candidate;
import exam.kommunalvalg.entity.Party;
import exam.kommunalvalg.repository.CandidateRepository;
import exam.kommunalvalg.repository.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;

    private final CandidateRepository candidateRepository;

    public PartyService(PartyRepository partyRepository, CandidateRepository candidateRepository) {
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
    }
public List<Party> getParties(){
        return partyRepository.findAll();
}


    public Party getPartyById(int id) {
        return partyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Party not found"));
    }

    public Party addCandidate(int partyId, Candidate candidate) {
        //Hent parti for at se om det findes
        Party party = partyRepository.findById(partyId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Party not found"));
        //Hent nuværende kandidater for at tilføje den nye kandidat
        List<Candidate> oldCandidates = party.getCandidates();
        //Opret den nye kandidat så vi kan gemme den i databasen
        Candidate newCandidate = new Candidate();
        //Sæt navnet på den nye kandidat
        newCandidate.setName(candidate.getName());
        //Sæt partiet på den nye kandidat
        newCandidate.setParty(party);
        //Gem den nye kandidat i databasen
        candidateRepository.save(newCandidate);
        //Tilføj den nye kandidat til listen af kandidater på partiet
        oldCandidates.add(candidate);
        //Gem partiet med den nye kandidat og de gamle kandidater
        party.setCandidates(oldCandidates);
        return partyRepository.save(party);
    }
}
