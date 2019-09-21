package pl.coderslab.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/addDonation")

public class DonationController {

    private final DonationPart1 donationPart1;
    private final DonationService donationService;
    private final CategoryService categoryService;

    public DonationController(DonationPart1 donationPart1, DonationService donationService, CategoryService categoryService) {
        this.donationPart1 = donationPart1;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/1")
    public String showAddDonation1(Model model){
        model.addAttribute("allCategories", categoryService.allCatiegories());
        model.addAttribute("donationPart1", donationPart1);
        return "addDonation1";
    }

    @PostMapping(value = "/1")
    public String addDonation1(@ModelAttribute DonationPart1 donationPart1){
        Donation donation = new Donation();
        List<Category> categories = donationPart1.getCategories();
        donation.setCategories(categories);
        donationService.save(donation);
        return "redirect:/";
    }

}
