package com.cruzeiro._23508825.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cruzeiro._23508825.model.Festa;
import com.cruzeiro._23508825.model.dto.FestaRequestDTO;

@Service
public interface FestaService {

	Festa createParty(FestaRequestDTO festaRequest) throws Exception;

	List<Festa> getAllFestas() throws Exception;

	Optional<Festa> searchById(Long id) throws Exception;

	void deleteFesta(Long id) throws Exception;

	List<Festa> getByParam(String param, String value) throws Exception;

}
