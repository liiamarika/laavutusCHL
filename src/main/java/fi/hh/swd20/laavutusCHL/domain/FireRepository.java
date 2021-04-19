package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FireRepository extends CrudRepository<Fire, Long> {
// By extending CrudRepository the FireRepository inherits methods for working with Fire persistence (mm save, delete)
	
	List<Fire> findByName(String name);
	
	// Enabling ORDER BY for a query
	 List<Fire> findByNameOrderByNameAsc(String name);
	 
}
