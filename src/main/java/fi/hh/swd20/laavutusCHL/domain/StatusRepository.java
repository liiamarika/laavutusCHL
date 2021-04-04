package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {

	List<Status> findByState(String state);
	
}
