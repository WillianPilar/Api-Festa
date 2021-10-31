package com.cruzeiro._23508825.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cruzeiro._23508825.model.dto.FestaRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema="public",  name="tb_festa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Festa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "solicitante")
	private String requester;
	
	@Column(name = "dia")
	private int day;
	
	@Column(name = "mes")
	private int month;
	
	@Column(name = "convidados")
	private String guests;
	
	public Festa(FestaRequestDTO festaRequest) {

		this.requester = festaRequest.getRequester();
		this.day = festaRequest.getDay();
		this.month = festaRequest.getMonth();
		this.guests = festaRequest.getGuests();
		
	}

}
