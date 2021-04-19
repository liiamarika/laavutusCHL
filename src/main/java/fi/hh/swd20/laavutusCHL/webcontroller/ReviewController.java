package fi.hh.swd20.laavutusCHL.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.laavutusCHL.domain.CategoryRepository;
import fi.hh.swd20.laavutusCHL.domain.FireRepository;
import fi.hh.swd20.laavutusCHL.domain.Review;
import fi.hh.swd20.laavutusCHL.domain.ReviewRepository;
import fi.hh.swd20.laavutusCHL.domain.StatusRepository;

@CrossOrigin
@Controller
public class ReviewController {

	// Spring-alusta luo sovelluksen käynnistyessä FireRepository-rajapintaa toteuttavan luokan olion ja kytkee 
	// olion FireController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
	@Autowired
	private ReviewRepository rrepository;
	@Autowired
	private FireRepository frepository;
	@Autowired
	private CategoryRepository crepository;
	@Autowired
	private StatusRepository srepository;
	
	// tuottaa listan arvosteluista
		@RequestMapping(value = "/reviewlist")
		public String reviewList (Model model) {
			model.addAttribute("reviews", rrepository.findAll());
			return "reviewlist";
		}
		
	// lisätään arvostelu lomakkeelta
		@RequestMapping(value = "/addreview")
		public String addReview (Model model) {
			model.addAttribute("review", new Review());
			// dropdown valikon kategoriat
			model.addAttribute("fires", frepository.findAll());
			return "addreview";
		}
		
	// tallennetaan arvostelu kantaan
		@RequestMapping(value = "/savereview", method = RequestMethod.POST)
		public String save (Review review) {
			rrepository.save(review);
			return "redirect:reviewlist";
		}
	
	
}
