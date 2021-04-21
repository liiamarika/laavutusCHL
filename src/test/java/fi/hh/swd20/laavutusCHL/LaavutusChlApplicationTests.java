package fi.hh.swd20.laavutusCHL;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.laavutusCHL.webcontroller.FireController;
import fi.hh.swd20.laavutusCHL.webcontroller.ReviewController;

@ExtendWith(SpringExtension.class) // JUnit5 / käyttää spring testing supportia
@SpringBootTest
class LaavutusChlApplicationTests {

	@Autowired
	private FireController fireController;
	
	@Autowired ReviewController reviewController;
	
	@Test // että kyseessä testi metodi, testataan että context luo controllerin
	void contextLoads() {
		assertThat(fireController).isNotNull();
		assertThat(reviewController).isNotNull();
	}

}
