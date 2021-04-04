package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FireRepository extends CrudRepository<Fire, Long> {

	List<Fire> findByName(String name);
}
