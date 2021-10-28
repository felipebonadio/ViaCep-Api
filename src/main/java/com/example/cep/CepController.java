package com.example.cep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")

public class CepController {

	@Autowired
	private CepRepository cepRepository;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public Cep findById(@PathVariable("id") Integer id) {
		Cep cep = this.cepRepository.findById(id);
		return cep;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<Cep> findAll() {
		List<Cep> cep = this.cepRepository.findAll();
		return cep;
	}
	
	@RequestMapping(value = "{numeroCep}", method = RequestMethod.GET, produces = "application/json")
	public Cep findByNumeroCep(@PathVariable("numeroCep") String numeroCep) {
		Cep cep = this.cepRepository.findByNumeroCep(numeroCep);
		return cep;
	}
	
	@RequestMapping(value = "/cidades/{cidade}", method = RequestMethod.GET, produces = "application/json")
	public List<Cep> findByCidade(@PathVariable("cidade") String cidade) {
		List<Cep> cep = this.cepRepository.findByCidade(cidade);
		return cep;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Cep save(@RequestBody Cep cep) {
		return cepRepository.save(cep);
	}
}