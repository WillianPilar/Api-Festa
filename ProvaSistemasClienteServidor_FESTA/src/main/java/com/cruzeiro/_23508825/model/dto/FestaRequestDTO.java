package com.cruzeiro._23508825.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FestaRequestDTO {

	private String requester;
	
	private int day;
	
	private int month;
	
	private String guests;
	
}
