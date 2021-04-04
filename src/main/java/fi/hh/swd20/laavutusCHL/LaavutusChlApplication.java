package fi.hh.swd20.laavutusCHL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.laavutusCHL.domain.Category;
import fi.hh.swd20.laavutusCHL.domain.CategoryRepository;
import fi.hh.swd20.laavutusCHL.domain.Fire;
import fi.hh.swd20.laavutusCHL.domain.FireRepository;
import fi.hh.swd20.laavutusCHL.domain.Status;
import fi.hh.swd20.laavutusCHL.domain.StatusRepository;


@SpringBootApplication
public class LaavutusChlApplication {

	private static final Logger log = LoggerFactory.getLogger(LaavutusChlApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(LaavutusChlApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner laavutusChlDemo (FireRepository frepository, CategoryRepository crepository, StatusRepository srepository) {
		return (args) -> {
			// luodaan testidataan kategoriat
			log.info("create and save some categories");
			Category category1 = new Category("Laavu");
			crepository.save(category1);
			Category category2 = new Category("Kota");
			crepository.save(category2);
			Category category3 = new Category("Nuotio");
			crepository.save(category3);
			
			// luodaan testidataan statukset
			log.info("create and save some statuses");
			Status status1 = new Status("Vierailtu");
			srepository.save(status1);
			Status status2 = new Status("Haluan mennnä");
			srepository.save(status2);
			Status status3 = new Status("Suosikki");
			srepository.save(status3);
			
			// luodaan testidataan tulipaikat
			log.info("create and save some fires");
			Fire fire1 = new Fire("Iso-Valkee", "Somero", "60.50777049121691, 23.717720805959097", category1, status3);
			frepository.save(fire1);
			Fire fire2 = new Fire("Kämmenlammen laavu", "Vihti", "60.357262436419475, 24.603438284506446", category1, status1);
			frepository.save(fire2);
			Fire fire3 = new Fire("Korsolammen nuotiopaikka", "Kirkkonummi", "60.16867191926468, 24.370582191436448", category3, status2);
			frepository.save(fire3);
		};
	}

}
