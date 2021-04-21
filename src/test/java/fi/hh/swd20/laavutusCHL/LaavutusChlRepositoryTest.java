package fi.hh.swd20.laavutusCHL;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.laavutusCHL.domain.Fire;
import fi.hh.swd20.laavutusCHL.domain.FireRepository;
import fi.hh.swd20.laavutusCHL.domain.Review;
import fi.hh.swd20.laavutusCHL.domain.ReviewRepository;


@ExtendWith(SpringExtension.class)  // JUnit5 / käyttää spring testing supportia
@DataJpaTest // konfiguroi in-memory tietokannan, JPAn ja Spring Datan, käynnistää SQL loggauksen
public class LaavutusChlRepositoryTest {

	@Autowired
	private FireRepository fRepository;
	
	@Autowired 
	private ReviewRepository rRepository;
	
	
	// testataan FireRepositoryn save-metodia - id ei voi olla null koska se luodaan automaattisesti
		 @Test 
		    public void addNewFire() {
			 	Fire fire = new Fire("Iso-Valkee", "Somero", "60.50777049121691, 23.717720805959097", null, null);
		    	fRepository.save(fire);
		    	assertThat(fire.getId()).isNotNull();
		    }   

		// testataan ReviewRepositoryn save-metodia - id ei voi olla null koska se luodaan automaattisesti
		 @Test 
		    public void addNewReview() {
		    	Review review = new Review("Erä-Remu", null, "Kaunis eväspaikka", "Tässä paikassa parasta oli eväät", null);
		    	rRepository.save(review);
		    	assertThat(review.getRid()).isNotNull();
		    }  
		 
		// testataan FireRepositoryn findByName-metodin toimivuutta - varmistetaan että sen nimisen paikan sijainti on tiedetty Somero
		 @Test  
		    public void findByNameShouldReturnFire() {
		        List<Fire> fires = fRepository.findByName("Iso-Valkee");
		        
		        assertThat(fires).hasSize(1);
		        assertThat(fires.get(0).getLocation()).isEqualTo("Somero");
		    }
		    
		// testataan ReviewRepositoryn findByNick-metodin toimivuutta - oikeasti subjectin testaaminen voidaan tehdä vain kun tiedetään sen olemmassaolo
			 @Test  
			   public void findByNickShouldReturnReview() {
			     List<Review> reviews = rRepository.findByNick("Erä-Remu");
			        
			       assertThat(reviews).hasSize(1);
			       assertThat(reviews.get(0).getSubject()).isEqualTo("Kaunis eväspaikka");
			    }
			 
		// testataan aiemman FireRepository lisäyksen poistamista
			 @Test
			 public void deleteByName() {
				 Long fire = fRepository.deleteByName("Iso-Valkee");
			 }
			
		// testataan aiemman ReviewRepository lisäyksen poistamista
		 @Test
		 	public void deleteByNick() {
			 Long review = rRepository.deleteByNick("Erä-Remu");
		 }
	
}
