package com.wipro.bank.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bank.bean.BankBean;
import com.wipro.bank.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Administrator admin = new Administrator();
    public String addRecord(HttpServletRequest request) {
    	BankBean bean = new BankBean();
    	try {
    		bean.setCustomerName(request.getParameter("customerName"));
    		bean.setAccountType(request.getParameter("accountType"));
    		String dateStr = request.getParameter("openingDate");
    		Date openingDate = Date.valueOf(dateStr);
    		bean.setOpeningDate(openingDate);
    		bean.setBalance(Integer.parseInt(request.getParameter("balance")));
    		bean.setContact(request.getParameter("contact"));
    		bean.setRemarks(request.getParameter("remarks"));
    		
    	} catch (Exception e) {
    		return "FAIL";
    	}
    	return admin.addRecord(bean);
    }
    
    public BankBean viewRecord(HttpServletRequest request) {
    	try {
    		String name = request.getParameter("customerName");
    		String dateStr = request.getParameter("openingDate");
    		Date openingDate = Date.valueOf(dateStr);
    		return admin.viewRecord(name, openingDate);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    public List<BankBean> viewAllRecords(HttpServletRequest request){
    	return admin.viewAllRecords();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		if(operation.equals("newRecord")) {
			String result = addRecord(request);
			System.out.println(result);
			if(result.equals("FAIL")||result.equals("INVALID INPUT")
					   ||result.equals("INVALID CUSTOMER NAME") ||
				       result.equals("INVALID DATE") ||
				       result.equals("ALREADY EXISTS")) {
				response.sendRedirect("error.html");
			} else {
				response.sendRedirect("success.html");
			}
		} else if(operation.equals("viewRecord")){
			BankBean bean = viewRecord(request);
			if(bean == null) {
				request.setAttribute("message", "No matching records exists! Please try again!");
				request.getRequestDispatcher("displayAccount.jsp").forward(request, response);
				
			} else {
				request.setAttribute("bankBean", bean);
				request.getRequestDispatcher("displayAccount.jsp").forward(request, response);
			}
		} else if (operation.equals("viewAllRecords")) {
			List<BankBean> list = viewAllRecords(request);
			if(list == null || list.isEmpty()) {
				request.setAttribute("message", "No records available!");
				request.getRequestDispatcher("displayAllAccounts.jsp").forward(request, response);
			} else {
				request.setAttribute("accountList", list);
				request.getRequestDispatcher("displayAllAccounts.jsp").forward(request, response);
			}
		}
	}

}
