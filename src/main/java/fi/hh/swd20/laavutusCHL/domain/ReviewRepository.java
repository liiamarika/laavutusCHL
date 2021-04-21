package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	List<Review> findByNick(String nick);
	
	Long deleteByNick(String nick);
	
}
