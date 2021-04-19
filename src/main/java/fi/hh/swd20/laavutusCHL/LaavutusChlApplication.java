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
import fi.hh.swd20.laavutusCHL.domain.Review;
import fi.hh.swd20.laavutusCHL.domain.ReviewRepository;
import fi.hh.swd20.laavutusCHL.domain.Status;
import fi.hh.swd20.laavutusCHL.domain.StatusRepository;
import fi.hh.swd20.laavutusCHL.domain.User;
import fi.hh.swd20.laavutusCHL.domain.UserRepository;


@SpringBootApplication
public class LaavutusChlApplication {

	private static final Logger log = LoggerFactory.getLogger(LaavutusChlApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(LaavutusChlApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner laavutusChlDemo (FireRepository frepository, CategoryRepository crepository, StatusRepository srepository, ReviewRepository rrepository, UserRepository urepository) {
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
			Status status2 = new Status("Vierailematta");
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
			
			// luodaan testikäyttäjiä
			log.info("save couple of users");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.fi", "USER");
			urepository.save(user1);
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");
			urepository.save(user2);
			User user3 = new User("liia", "$2a$10$eLgmttXgTYdiq3ieqTXR8OBKWgdF/AERV6DoG84GjmrD/LQ30CKRy", "liia@liia.fi", "ADMIN");
			urepository.save(user3);


			// näytetään luodut testidatat consolessa
			log.info("Fetch all categories");
			for (Category category : crepository.findAll()) {
			   log.info(category.toString());
			}
			
			log.info("Fetch all statuses");
			for (Status status : srepository.findAll()) {
			   log.info(status.toString());
			}
			
			log.info("Fetch all fires");
			for (Fire fire : frepository.findAll()) {
			   log.info(fire.toString());
			}
			
			log.info("Fetch all users");
			for (User user : urepository.findAll()) {
			   log.info(user.toString());
			}
		};
	}

}
