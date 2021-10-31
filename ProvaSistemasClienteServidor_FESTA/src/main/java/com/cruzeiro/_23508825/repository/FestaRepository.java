package com.cruzeiro._23508825.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cruzeiro._23508825.model.Festa;

@Repository
public interface FestaRepository extends JpaRepository<Festa, Long>{
	
	@Query(value="SELECT * FROM tb_festa WHERE :param = :value",
			nativeQuery = true)
	List<Festa> findAllByParam(@Param("param")String param,  @Param("value") String value);

}
