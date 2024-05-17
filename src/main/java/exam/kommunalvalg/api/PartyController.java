package exam.kommunalvalg.api;


import exam.kommunalvalg.entity.Candidate;
import exam.kommunalvalg.entity.Party;
import exam.kommunalvalg.service.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }
    @GetMapping
    public List<Party> getParties(){
        return partyService.getParties();
    }
    @GetMapping("/{id}")
    public Party getPartyById(@PathVariable int id){
        return partyService.getPartyById(id);
    }
    @PostMapping("/{partyId}/add-candidate")
    public Party addCandidate(@PathVariable int partyId, @RequestBody Candidate candidate){
    return partyService.addCandidate(partyId, candidate);}


}
