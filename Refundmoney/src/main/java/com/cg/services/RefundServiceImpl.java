package com.cg.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Return;
import com.cg.bean.Transaction;
import com.cg.dao.CapstoreDAO;
import com.cg.dao.ProductDAO;
import com.cg.dao.ReturnDAO;
import com.cg.dao.TransactionDAO;




@Service
@Transactional
public class RefundServiceImpl implements RefundService{
	
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private ReturnDAO returnDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CapstoreDAO capstoreDAO;

	
	@Transactional
	public void approveRefund(Integer transactionId) {
		// TODO Auto-generated method stub
		
		Transaction transactionObject=transactionDAO.findById(transactionId).get();
		returnDAO.approveRefund( transactionObject);
		updateRevenue(transactionId);
	}


	@Override
	public void updateRevenue(Integer transactionId) {
		
		
		Double total=0.0;
		Integer price=0;
		
		Transaction transactionObject=transactionDAO.findById(transactionId).get();
		
		List<Integer[]> productsList=transactionObject.getProducts();
		
		for(Integer[] productDetails:productsList) {
			
				price=productDAO.getOne(productDetails[0]).getPrice();
				total+=productDetails[1]*price;
			
		}
		
		capstoreDAO.updateRevenueForRefund(total);
		
		
	}
	
	
	
	
	 
}
