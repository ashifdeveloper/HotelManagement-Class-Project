# Hotel Management App

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
  
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>
   
An easy-to-use online application, this project enables users add hotel rooms, get all hotel rooms by id, and maintain their personal data. Users also have the option of posting and viewing posts made by other users. 
---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* H2 Database
* Lombok
* Validation

<br>

## Database Configuration
By adding the correct database URL, user name, and password to the application.properties file, you can connect to a H2 database. It's time to update the following properties:
```
spring.datasource.url=jdbc:h2:mem:<database nama>
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=<user name>
spring.datasource.password=<password>
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true



spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true


#EnableH2Console-http://localhost:8080/h2-console


```
<br>

## Language Used
* Java


## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

### 1. Controller

- **GET /rooms**
  - Function: `getAllRooms()`
  - Description: Retrieves all existing hotel rooms.
  - Input: None
  - Output: List of `HotelRoom` objects in JSON format.

- **POST /room**
  - Function: `addRoom(@RequestBody HotelRoom room)`
  - Description: Adds a new hotel room to the system.
  - Input: `HotelRoom` object in JSON format representing the new room.
  - Output: A string indicating the result of the room addition process.

### 2. Services

- **RoomService**
  - Function: `getAllRooms()`
  - Description: Retrieves all existing hotel rooms.
  - Input: None
  - Output: List of `HotelRoom` objects.

- **RoomService**
  - Function: `addRoom(HotelRoom room)`
  - Description: Adds a new hotel room to the system.
  - Input: `HotelRoom` object representing the new room.
  - Output: A string indicating the result of the room addition process.


### 4. Database Design


## DataBase Used
* H2 database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>
## Data Structure Used in Your Project

- The data structure used for representing hotel rooms is likely based on the `HotelRoom` class/model, but specific details were not provided in the code snippet.

## Project Summary

The Hotel Management System's Room Controller is responsible for handling requests related to hotel rooms. It provides endpoints for retrieving all existing rooms and adding a new room to the system. The controller is built using Java and Spring Boot, employing Spring Web for creating RESTful APIs. Data flow involves interactions between the Controller and the Service layer, where the RoomService performs operations on the data (e.g., retrieving and adding rooms). The project's data structure is centered around the `HotelRoom` class/model, which likely contains essential information about the hotel rooms.

## Author

👤 **Mohammad Ashif**

* GitHub: [Mohammad Ashif]( https://github.com/ashifdeveloper)

    
---

## 🤝 Contributing

Contributions, issues and feature requests are welcome.
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
    
## 📝 License

Copyright © 2023 [Mohammad Ashif]( https://github.com/ashifdeveloper).<br />
    
---

