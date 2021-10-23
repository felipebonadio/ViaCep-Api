package com.example.cep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/cep")
public class CepController {

	@Autowired
	private CepRepository cepRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Cep findId(@PathVariable("id") Integer id) {
		Cep cep = this.cepRepository.findById(id);
		return cep;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<Cep> findAll() {
		List<Cep> cep = this.cepRepository.findAll();
		return cep;
	}
	
}