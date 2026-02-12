package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.bank.bean.BankBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {
	public String createRecord(BankBean bankBean) {
		String recordID="FAIL";
		Connection con = DBUtil.getDBConnection();
        String query = "INSERT INTO BANKACCOUNT_TB VALUES (?,?,?,?,?,?,?)";
        
		try {
			recordID = generateRecordID(bankBean.getCustomerName(),bankBean.getOpeningDate());
			bankBean.setRecordID(recordID);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,bankBean.getRecordID());
			ps.setString(2,bankBean.getCustomerName());
			ps.setString(3,bankBean.getAccountType());
			ps.setDate(4,bankBean.getOpeningDate());
			ps.setInt(5,bankBean.getBalance());
			ps.setString(6,bankBean.getContact());
			ps.setString(7,bankBean.getRemarks());
			int rows = ps.executeUpdate();
			if(rows > 0) {
				return recordID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	
	public BankBean fetchRecord(String customerName, Date openingDate) {
		BankBean bean = null;
		
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM BANKACCOUNT_TB WHERE CUSTOMER_NAME = ? AND OPENING_DATE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerName);
	        ps.setDate(2, openingDate);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean=new BankBean();
				bean.setRecordID(rs.getString("RECORD_ID"));
				bean.setCustomerName(rs.getString("CUSTOMER_NAME"));
				bean.setAccountType(rs.getString("ACCOUNT_TYPE"));
				bean.setOpeningDate(rs.getDate("OPENING_DATE"));
				bean.setBalance(rs.getInt("BALANCE"));
				bean.setContact(rs.getString("CONTACT"));
				bean.setRemarks(rs.getString("REMARKS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public String generateRecordID(String customerName, Date openingDate) {
		String recordID = "";
		Connection con = DBUtil.getDBConnection();
		try {
			Statement st = con.createStatement();
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			String temp = format.format(openingDate);
			
			String nameFormat = customerName.substring(0,2).toUpperCase();
			ResultSet rs = st.executeQuery("SELECT BANKACCOUNT_SEQ.NEXTVAL FROM DUAL");
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			recordID = temp + nameFormat + String.format("%02d", seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordID;
	}
	
	public boolean recordExists(String customerName, Date openingDate) {
		boolean exists = false;
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT 1 FROM BANKACCOUNT_TB WHERE CUSTOMER_NAME = ? AND OPENING_DATE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,customerName);
			ps.setDate(2, openingDate);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	public List<BankBean> fetchAllRecords(){
		List<BankBean> list = new ArrayList();
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM BANKACCOUNT_TB";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BankBean bean = new BankBean();
				bean.setRecordID(rs.getString("RECORD_ID"));
				bean.setCustomerName(rs.getString("CUSTOMER_NAME"));
				bean.setAccountType(rs.getString("ACCOUNT_TYPE"));
				bean.setOpeningDate(rs.getDate("OPENING_DATE"));
				bean.setBalance(rs.getInt("BALANCE"));
				bean.setContact(rs.getString("CONTACT"));
				bean.setRemarks(rs.getString("REMARKS"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
