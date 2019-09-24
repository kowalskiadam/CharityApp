package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        model.addAttribute("fourInstitutions", institutionService.showFourInstitution());
        model.addAttribute("totalQuantity", donationService.totalQuantity());
        model.addAttribute("allInstitution", institutionService.allInstitutionCount());
        return "index";
    }
}
