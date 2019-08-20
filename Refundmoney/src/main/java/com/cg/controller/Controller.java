package com.cg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Return;
import com.cg.bean.Transaction;
import com.cg.services.RefundService;
import com.cg.services.RefundServiceImpl;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/refund")
public class Controller {
	
	
	@Autowired
	private RefundService refundService;
	
		
	
	
	@PutMapping(value="/record/approve/{transactionId}")
	public String approveRefund(@PathVariable Integer transactionId){
		try {
		refundService.approveRefund(transactionId);}
		catch(Exception e) {
			return e.getMessage();
		}
		return "Refund Approved";
	}

	
	
}
