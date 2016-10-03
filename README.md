# Assignment- Retail Management System

Retail Management System using Spring Boot RESTful Web Services

Overview
========
It's a Retail Management System built using built using Spring Boot. It contains RESTful web services to add new shop and to locate nearest shop. It uses google's Geocoding API.

Dependencies
============
This project requires JDK 8, Maven/Gradle. It also requires Google API key to access Geocoding API.
Update Google's API key value for **API_KEY** static variable in below class.  
**src/main/java/com/example/ws/util/ApplicationUtils.java**  

Building / Running
==================
Project can be built by using maven or gradle. Use folowing steps to build the project.
maven  
-----  
Go to project directory and build using **mvn clean package**  
Go to /target directory and run jar using **java -jar retail-management-<version>.jar**  

gradle  
------  
Go to project directory and build using **gradle clean build**  
Go to /build/libs directory and run jar using **java -jar retail-management-<version>.jar**  

API
===
The API allows for GET, POST requests.  

POST
----
**/RetailManagementSystem/addShop**: Takes the JSON payload and stores it in in-memory array, returning the JSON payload with an added Longitude and Latitude of the shop.  
This api can be accessed by only manager. i.e. it expects header parameter with name 'user' and value 'manager'.

GET
---
**/RetailManagementSystem/getNearestShop/{customerLongitude}/{customerLatitude}**: Returns the nearest shop based on the customer's longitude and latitude.  
This api can be accessed by manager and customer. i.e. it expects header parameter with name 'user' and value 'manager' or 'customer'.

Errors
======
The API will return an error payload if any of required filed is missing, if Geocoding API not able to find the location, if unvalid URIs are requested or invalid or unsupported request methods are used.  
