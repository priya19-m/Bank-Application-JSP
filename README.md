## Bank Account Management System
## Project Overview:
   The Bank Account Management System is a Java-based web application developed using JSP, Servlets, JDBC, and Object-Oriented Programming (OOP) concepts.
   This system helps manage bank operations such as adding new account records, viewing individual account details, and viewing all account records stored in the database.
   The project follows a layered architecture using Bean, DAO, Service, Servlet, and Utility layers, ensuring proper separation of concerns, modular design, and easy maintenance.
   
## Objectives:
   The system is designed to:
     1. Add new bank account records
     2. Generate unique Record ID using Oracle Sequence
     3. View specific account details
     4. View all account records
     5. Validate user input before storing data
     6. Prevent duplicate records
     7. Perform database operations using JDBC
     8. Handle user requests using Servlets
     9. Provide simple HTML-based user interfaces
    10. Apply DAO pattern and Service layer architecture

## Technologies Used:
Programming Language: Java
Web Technologies: JSP, HTML, Servlets
Database: Oracle Database
Connectivity: JDBC
IDE: Eclipse IDE
Server: Apache Tomcat
Version Control: Git & GitHub

## Project Structure:
BankApplication
├── src/main/java
│   └── com.wipro.bank
│       ├── bean
│       │   └── BankBean.java
│       ├── dao
│       │   └── BankDAO.java
│       ├── service
│       │   └── Administrator.java
│       ├── servlets
│       │   └── MainServlet.java
│       └── util
│           ├── DBUtil.java
│           └── InvalidInputException.java
├── src/main/webapp
│   ├── META-INF
│   ├── WEB-INF
│   ├── AddAccount.html
│   ├── ViewAccount.html
│   ├── Menu.html
│   ├── success.html
│   └── error.html
└── build

## How to Run in Eclipse IDE:
Step 1: Install Required Software
Eclipse IDE
Apache Tomcat Server (v9.0 or above)
Oracle Database
Oracle JDBC Driver (ojdbc8.jar / ojdbc11.jar / ojdbc17.jar)

Step 2: Import Project
Open Eclipse
Go to File → Import
Select Existing Dynamic Web Project
Select the BankApplication folder
Click Finish

Step 3: Configure Tomcat Server
Go to Servers tab
Add Apache Tomcat
Configure server runtime environment

Step 4: Add JDBC Driver
Right-click project
Build Path → Add External Archives
Select ojdbc jar file

Step 5: Run the Project
Right-click project
Run As → Run on Server
Choose Tomcat Server

## Database Details:
Tables Used:
  1. BANKACCOUNT_TB – Stores account details
  <img width="954" height="317" alt="Screenshot 2026-02-12 231121" src="https://github.com/user-attachments/assets/32d4eb91-969c-4c27-8b6f-2a666167162b" />

  2. BANKACCOUNT_SEQ
  <img width="511" height="179" alt="Screenshot 2026-02-12 231139" src="https://github.com/user-attachments/assets/8072a078-f7ee-4ac2-8cb1-90d18f45b32e" />

## OUTPUT:
<img width="1919" height="612" alt="Screenshot 2026-02-12 220823" src="https://github.com/user-attachments/assets/24276518-37e2-4e9b-ba89-041aef0f202e" />
<img width="1915" height="638" alt="Screenshot 2026-02-12 220812" src="https://github.com/user-attachments/assets/e3b1fcaf-c94e-487f-88d6-c358037163b2" />
<img width="1919" height="633" alt="Screenshot 2026-02-12 221012" src="https://github.com/user-attachments/assets/535df6df-eba8-47ad-aa34-492435063102" />
<img width="1919" height="624" alt="Screenshot 2026-02-12 230821" src="https://github.com/user-attachments/assets/d1ae4590-e472-40c0-9c4f-f32c8987cf1b" />
<img width="1919" height="977" alt="Screenshot 2026-02-12 231057" src="https://github.com/user-attachments/assets/7192e26e-09c2-4aea-9bf0-6affd73313e2" />
<img width="1914" height="660" alt="Screenshot 2026-02-13 100451" src="https://github.com/user-attachments/assets/25f793c1-6ae2-463d-bbbe-b216036d4c2b" />
<img width="1641" height="409" alt="Screenshot 2026-02-13 100507" src="https://github.com/user-attachments/assets/b06b8a9d-47b1-4a77-b4a3-8c3b6b75cfb4" />

## Student Details:
NAME: PRIYADHARSHINI M  
ROLL NO: 717823P141




  
