package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Return;
import com.cg.bean.Transaction;
import com.cg.bean.User1;

@Repository
public interface ReturnDAO  extends JpaRepository<Return, Integer>{

	
	@Transactional
	@Modifying
	@Query("update Return r set r.status='\"refund approved\"' where r.transaction=?1")
	public void approveRefund(Transaction transactionObject);
	
	
}
