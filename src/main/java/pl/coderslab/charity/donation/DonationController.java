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

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/addDonation")

public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final Validator validator;
    private final Donation donation;

    public DonationController(DonationPart1 donationPart1, DonationService donationService, CategoryService categoryService, Validator validator, Donation donation) {
        this.donationService = donationService;
        this.categoryService = categoryService;
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
        return "redirect:/";
    }

    @ModelAttribute("allCategories")
    public List<Category> allCategories(){
        return categoryService.allCatiegories();
    }


}
