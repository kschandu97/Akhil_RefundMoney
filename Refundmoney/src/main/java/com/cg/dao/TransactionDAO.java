package com.cg.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Transaction;
@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer>{
	
	
}
