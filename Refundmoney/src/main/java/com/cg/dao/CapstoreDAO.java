package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Capstore;

@Repository
public interface CapstoreDAO extends JpaRepository<Capstore, Integer>{
	
	@Transactional
	@Modifying
	@Query("update Capstore c set c.balance=c.balance-?1")
	public void updateRevenueForRefund(Double amount);

}
