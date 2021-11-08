package com.example.cep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")

public class CepController {

	@Autowired
	private CepRepository cepRepository;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cep> findById(@PathVariable("id") Integer id) {
		Cep cep = this.cepRepository.findById(id);
		if (cep == null) {
			return new ResponseEntity<Cep>(cep, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Cep>(cep, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cep>> findAll() {
		List<Cep> cep = this.cepRepository.findAll();
		if (cep.isEmpty()) {
			return new ResponseEntity<List<Cep>>(cep, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cep>>(cep, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cep> findByCep(@PathVariable("cep") String cep) {
		Cep numeroCep = this.cepRepository.findByCep(cep);
		if (cep == null) {
			return new ResponseEntity<Cep>(numeroCep, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Cep>(numeroCep, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/cidades/{cidade}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cep>> findByLocalidade(@PathVariable("cidade") String localidade) {
		List<Cep> cep = this.cepRepository.findByLocalidade(localidade);
		if (cep.isEmpty()) {
			return new ResponseEntity<List<Cep>>(cep, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cep>>(cep, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Cep> save(@RequestBody Cep cep, BindingResult bindingResult) {
		cepRepository.save(cep);
		if(bindingResult.hasErrors() || (cep == null)){
			return new ResponseEntity<Cep>(cep, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cep>(cep, HttpStatus.CREATED); 
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Cep> deleteById(@PathVariable("id") Integer id) {			
		Cep cepId = this.cepRepository.findById(id);		
		cepRepository.delete(cepId);	
		if (cepId == null) {
			return new ResponseEntity<Cep>(cepId, HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Cep>(cepId, HttpStatus.OK);	
	}
}