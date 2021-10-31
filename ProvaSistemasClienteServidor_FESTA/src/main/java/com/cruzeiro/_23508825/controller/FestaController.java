package com.cruzeiro._23508825.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cruzeiro._23508825.model.Festa;
import com.cruzeiro._23508825.model.dto.FestaRequestDTO;
import com.cruzeiro._23508825.service.FestaService;

@RestController
@RequestMapping("/party/api/v1")
public class FestaController {
	
	@Autowired
	private FestaService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FestaController.class);
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Festa createFesta(@RequestBody FestaRequestDTO festaRequest){
		
		Festa festaResponse = null;
		try {
			
			festaResponse = service.createParty(festaRequest);
			
		} catch (Exception e) {
			
			LOGGER.error("Erro ao criar festa: ", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			
		}
			
		return festaResponse;
		
	}
	
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public List<Festa> getByParam(	@RequestParam(value = "param", defaultValue="solicitante") String param,
									@RequestParam(value = "value") String value){
		List<Festa> festa = null;
		try {
			
			festa = service.getByParam(param, value);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao pesquisar festas com os parametrôs passados: ", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return festa;
		
	}
	
	@GetMapping("/search-all")
	@ResponseStatus(HttpStatus.OK)
	public List<Festa> searchAllFestas(){
		
		List<Festa> listFesta =  new ArrayList<>();
		
		try {
			
			listFesta = service.getAllFestas();
			
		} catch (Exception e) {
			
			LOGGER.error("Erro ao pesquisar as festas registradas: ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return listFesta;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> DeleteFesta(@PathVariable("id") Long id) {
		
		try {
			
			Optional<Festa> festaId = service.searchById(id);
			if (festaId.isPresent()) {
				service.deleteFesta(id);
			}else {
				LOGGER.error("Festa não encontrada");
				return ResponseEntity.notFound().build();
			}
			
		} catch (Exception e) {
			LOGGER.error("Erro ao deletar a festa pelo ID: ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.ok().build();
				
	}

}
