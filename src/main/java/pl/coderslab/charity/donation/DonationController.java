package pl.coderslab.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/addDonation")

public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final Validator validator;
    private final Donation donation;

    public DonationController(DonationPart1 donationPart1, DonationService donationService, CategoryService categoryService, InstitutionService institutionService, Validator validator, Donation donation) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.validator = validator;
        this.donation = donation;
    }


    @GetMapping(value = "/1")
    public String showAddDonation1(Model model){
        model.addAttribute("donationPart1", new DonationPart1());
        return "addDonation1";
    }

    @PostMapping(value = "/1")
    public String addDonation1(@ModelAttribute @Valid DonationPart1 donationPart1, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("donationPart1", donationPart1);
            return "addDonation1";
        }
        List<Category> categories = donationPart1.getCategories();
        donation.setCategories(categories);
        System.out.println(donation.toString());
        return "redirect:/addDonation/2";
    }

    @GetMapping(value = "/2")
    public String showAddDonation2(Model model){
        model.addAttribute("donationPart2", new DonationPart2());
        if(donation.getQuantity() == null){
            donation.setQuantity(0);
        }
        return "addDonation2";
    }

    @PostMapping(value = "/2")
    public String addDonation2(@ModelAttribute @Valid DonationPart2 donationPart2, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("donationPart2", donationPart2);
            return "addDonation2";
        }
        donation.setQuantity(donationPart2.getQuantity());
        System.out.println(donation.toString());
        return "redirect:/addDonation/3";
    }

    @GetMapping(value = "/3")
    public String showAddDonation3(Model model){
        model.addAttribute("donationPart3", new DonationPart3());
        if(donation.getInstitution() == null){
            donation.setInstitution(institutionService.findFirst());
        }
        return "addDonation3";
    }

    @PostMapping(value = "/3")
    public String addDonation3(@ModelAttribute @Valid DonationPart3 donationPart3, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("donationPart3", donationPart3);
            return "addDonation3";
        }
        donation.setInstitution(donationPart3.getInstitution());
        System.out.println(donation.toString());
        return "redirect:/addDonation/4";
    }

    @GetMapping(value = "/4")
    public String showAddDonation4(Model model){
        model.addAttribute("donationPart4", new DonationPart4());
        return "addDonation4";
    }

    @PostMapping(value = "/4")
    public String addDonation4(@ModelAttribute @Valid DonationPart4 donationPart4, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("donationPart4", donationPart4);
            return "addDonation4";
        }
        System.out.println(donation.toString());
        donation.setCity(donationPart4.getCity());
        donation.setPickUpComment(donationPart4.getPickUpComment());
        donation.setPickUpDate(donationPart4.getPickUpDate());
        donation.setPickUpTime(donationPart4.getPickUpTime());
        donation.setStreet(donationPart4.getStreet());
        donation.setZipCode(donationPart4.getZipCode());
        Donation finalDonation = new Donation();
        finalDonation.setInstitution(donation.getInstitution());
        finalDonation.setCategories(donation.getCategories());
        finalDonation.setQuantity(donation.getQuantity());
        finalDonation.setCity(donationPart4.getCity());
        finalDonation.setPickUpComment(donationPart4.getPickUpComment());
        finalDonation.setPickUpDate(donationPart4.getPickUpDate());
        finalDonation.setPickUpTime(donationPart4.getPickUpTime());
        finalDonation.setStreet(donationPart4.getStreet());
        finalDonation.setZipCode(donationPart4.getZipCode());
        donationService.save(finalDonation);
        return "redirect:/";
    }


    @ModelAttribute("allCategories")
    public List<Category> allCategories(){
        return categoryService.allCatiegories();
    }

    @ModelAttribute("allInstitutions")
    public List<Institution> allInstitutions(){
        return institutionService.allInstitution();
    }

    @ModelAttribute("donation")
    public Donation sessionDodanation(){
        return donation;
    }

}
