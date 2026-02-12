package com.wipro.bank.service;

import java.sql.Date;
import java.util.List;

import com.wipro.bank.bean.BankBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.InvalidInputException;

public class Administrator {
	BankDAO bankDAO = new BankDAO();
	
	public String addRecord(BankBean bankBean) {
		try {
			if(bankBean == null || bankBean.getCustomerName()==null || bankBean.getOpeningDate()==null ) {
				throw new InvalidInputException();
			}
			if(bankBean.getCustomerName().length()<2) {
				return "INVALID CUSTOMER NAME";
			}
			Date today = new Date(System.currentTimeMillis());
			if(bankBean.getOpeningDate().compareTo(today)>0) {
				return "INVALID DATE";
			}
			if(bankDAO.recordExists(bankBean.getCustomerName(), bankBean.getOpeningDate())) {
				return "ALREADY EXISTS";
			}
			String result = bankDAO.createRecord(bankBean);
			return result;
			
		} catch (InvalidInputException e) {
			return "INVALID INPUT";
		}
	}
	
	public BankBean viewRecord(String customerName, Date openingDate) {
		try {
			if(customerName == null || openingDate == null) {
				throw new InvalidInputException();
			}
			return bankDAO.fetchRecord(customerName, openingDate);
		} catch (InvalidInputException e) {
			return null;
		}
	}
	
	public List<BankBean> viewAllRecords(){
		return bankDAO.fetchAllRecords();
	}

}
