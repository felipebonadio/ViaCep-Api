package com.example.cep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CepRepository extends CrudRepository<Cep, Long> {

	List<Cep> findAll();
	Cep findById(int id);
}