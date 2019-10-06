package pl.javastart.sellegro.auction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuctionController {

    private AuctionRepository auctionRepository;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/auctions")
    public String auctions(Model model,
                           @RequestParam(required = false) String sort,
                           AuctionFilters auctionFilters) {

        List<Auction> auctions = new ArrayList<>();

        if (sort != null) {
            if ("color".equals(sort)) {
                auctions = auctionRepository.findByOrderByColor();
            } else if ("carModel".equals(sort)) {
                auctions = auctionRepository.findByOrderByCarModel();
            } else if ("endDate".equals(sort)) {
                auctions = auctionRepository.findByOrderByEndDate();
            } else if ("price".equals(sort)) {
                auctions = auctionRepository.findByOrderByPrice();
            }
        } else {
            auctions = auctionRepository.findAll();
        }


        model.addAttribute("cars", auctions);
        model.addAttribute("filters", auctionFilters);
        return "auctions";
    }
}
