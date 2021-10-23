package com.example.cep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Cep2Repository extends CrudRepository<Cep2, Long>{
	
	List<Cep2> findByLocalidade(String localidade);	
	
	Cep2 findById(long id);

	
}
