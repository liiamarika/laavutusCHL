package fi.hh.swd20.laavutusCHL.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.laavutusCHL.domain.CategoryRepository;
import fi.hh.swd20.laavutusCHL.domain.Fire;
import fi.hh.swd20.laavutusCHL.domain.FireRepository;
import fi.hh.swd20.laavutusCHL.domain.ReviewRepository;
import fi.hh.swd20.laavutusCHL.domain.StatusRepository;

@CrossOrigin
@Controller
public class FireController {

	// Spring-alusta luo sovelluksen käynnistyessä FireRepository-rajapintaa toteuttavan luokan olion ja kytkee 
	// olion FireController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
	@Autowired
	private FireRepository frepository;
	@Autowired
	private CategoryRepository crepository;
	@Autowired
	private StatusRepository srepository;
	@Autowired
	private ReviewRepository rrepository;
	
	
	// http://localhost:8080/mitävaan
		@RequestMapping("*")
		public String startPage() {
			return "index";
		}
	
	
	// tuottaa listan tulipaikoista
	@RequestMapping(value = "/firelist")
	public String fireList (Model model) {
		model.addAttribute("fires", frepository.findAll());
		return "firelist";
	}
	
	// lisätään paikka lomakkeelta
	@RequestMapping(value = "/addfire")
	public String addFire (Model model) {
		model.addAttribute("fire", new Fire());
		// dropdown valikon kategoriat
		model.addAttribute("categories", crepository.findAll());
		// dropdown valikon statukset
		model.addAttribute("statuses", srepository.findAll());
		return "addfire";
	}
	
	// tallennetaan tulipaikka kantaan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save (Fire fire) {
		frepository.save(fire);
		return "redirect:firelist";
	}
	
	// poistetaan tulipaikka idn perusteella
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete (@PathVariable(value= "id") long id) {
		frepository.deleteById(id);
		return "redirect:/firelist";
	}
		
	// haetaan tulipaikka idn perusteella muokattavaksi lomakkeelle
	@RequestMapping(value = "/edit/{id}")
	public String edit (@PathVariable(value="id") long id, Model model) {
		model.addAttribute("fire", frepository.findById(id));
		// dropdown valikon kategoriat
		model.addAttribute("categories", crepository.findAll());
		// dropdown valikon statukset
		model.addAttribute("statuses", srepository.findAll());
		return "editfire";
	}

	// haetaan tulipaikkaan liittyvät arvostelut
	@RequestMapping(value= "/fire/{id}")
	public String fire (@PathVariable(value="id") long id, Model model) {
		model.addAttribute("fire", frepository.findById(id));
		model.addAttribute("review", rrepository.findAll());
		return "fire";
	}
	
			
}
