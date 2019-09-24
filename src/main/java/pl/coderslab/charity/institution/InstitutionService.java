package pl.coderslab.charity.institution;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;


    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> showFourInstitution(){
        List<Institution> institutions = new ArrayList<>();
        return institutionRepository.findTop4ByOrderById();
    }

    public Long allInstitutionCount(){
        return institutionRepository.count();
    }

    public List<Institution> allInstitution(){return institutionRepository.findAll();}

    public Institution findFirst() {return institutionRepository.findTop1ByOrderById();}
}
