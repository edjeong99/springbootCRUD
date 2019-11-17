 ## Overview/Purpose
This project is a sample JAVA Springboot project that provide CRUD operation for DB.  The project manages book info and provide API for get, create, edit and delete functionalities.

## Installation
Download the codes, import the project to Eclipse as a Maven project and run Maven update.  Then run “DemoApplication.java” in src.main/java - com.dd.demo package.  The local host will be running in port 3000.  You need to change values for "spring.datasource" variable for proper DB connection.

## Architecture/Tech Stack
Java, Springboot, Tomcat
 

## URL endpoints
GET :  /bookAPI/books : return list of all book 
POST : /bookAPI/books : adding a book. takes a book class in the body of request
PUT : /bookAPI/books : edit a book. takes a book class in the body of request
DELETE :/bookAPI/books/id : delete a book with given id


## Screenshots
In below link, you can see screenshots of API call and sample codes
https://docs.google.com/document/d/1ryRsnsQ6joJuMmFcYVeqhxRhvCf-28Rlvtl7JT2KyLI/edit?usp=sharing
