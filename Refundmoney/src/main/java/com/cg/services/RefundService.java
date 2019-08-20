package com.cg.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bean.Return;
import com.cg.bean.Transaction;
@Service
public interface RefundService {
public void approveRefund(Integer transactionId);

public void updateRevenue(Integer transactionId);

}
