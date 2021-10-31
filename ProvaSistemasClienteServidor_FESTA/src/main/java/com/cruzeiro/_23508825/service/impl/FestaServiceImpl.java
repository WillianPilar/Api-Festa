package com.cruzeiro._23508825.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruzeiro._23508825.model.Festa;
import com.cruzeiro._23508825.model.dto.FestaRequestDTO;
import com.cruzeiro._23508825.repository.FestaRepository;
import com.cruzeiro._23508825.service.FestaService;

@Service
public class FestaServiceImpl implements FestaService{

	@Autowired
	private FestaRepository repository;
	
	@Override
	public Festa createParty(FestaRequestDTO festaRequest) throws Exception {
		
		Festa festaSave = new Festa(festaRequest);

		return repository.save(festaSave);
	
	}

	@Override
	public List<Festa> getAllFestas() throws Exception {

		return repository.findAll();
	
	}

	@Override
	public Optional<Festa> searchById(Long id) throws Exception {

		return repository.findById(id);
	
	}

	@Override
	public void deleteFesta(Long id) throws Exception {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<Festa> getByParam(String param, String value) throws Exception {
		
		List<Festa> festaReturn = null;
		Optional<Festa> festaId = null;
		
		if (param.equals("id")) {
			
			Long id = Long.valueOf(value);
			festaId = repository.findById(id);
			
			Festa festa = new Festa(festaId.get().getId(), festaId.get().getRequester(), festaId.get().getDay(),
									festaId.get().getMonth(), festaId.get().getGuests());
			festaReturn = new ArrayList<Festa>();
			festaReturn.add(festa);
			
		}else {
			
			festaReturn = repository.findAllByParam(param, value);
			
		}
		
		return festaReturn;
	}

}
