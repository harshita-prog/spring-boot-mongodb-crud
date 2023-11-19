# spring-boot-mongodb-crud

This project explains CRUD (**C**reate, **R**ead, **U**pdate, **D**elete) operations using MongoTemplate and MongoRepository using spring boot and mongo DB.
In this app we are using Spring Data JPA for built-in methods to do CRUD operations and Mongo queries using MongoTemplate.     
`@EnableMongoRepositories` annotation is used on main class to Enable Mongo related configuration, which will read properties from `application.properties` file.



## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Mongo DB](https://docs.mongodb.com/guides/)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE)
- Maven (version >= 3.6.0)
- Swagger UI (or any RESTful API testing tool)


<br/>


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-mongodb**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-spring-boot-mongodb/target/spring-boot-mongodb-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `SpringBootMongoDBApplication.java` as spring boot application.  


||
|  ---------    |
| **_Note_** : In `SpringBootMongoDBApplication.java` class we have autowired Employee repositories. <br/>If there is no record present in DB for any one of that module class (Employee), static data is getting inserted in DB from `HelperUtil.java` class when we are starting the app for the first time.| 



### Code Snippets
1. #### Maven Dependencies
    Need to add below dependencies to enable Mongo related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.   
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```
   
   
2. #### Properties file
    Reading Mongo DB related properties from **application.properties** file and configuring Mongo connection factory for mongoDB.  

    **src/main/resources/application.properties**
     ```
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=database_name
    spring.jackson.default-property-inclusion=NON_NULL
    #logging.level.ROOT=DEBUG  
     ```
   
   
3. #### Model class
    Below are the model classes which we will store in MongoDB and perform CRUD operations.  
    **model.com.demo.Employee.java**  
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Employee implements Serializable {
   
        @Id
        private String id;
       
        private int empId;
        private String firstName;
        private String lastName;
        private float salary;
        
        // Constructor, Getter and Setter
    }
   ```
   
4. #### JPA And Query operation for Employee
    In **controller.com.demo.EmployeeController.java** class JPA related queries API Endpoints are placed.
    In **controller.com.demo.EmployeeQueryController.java** class Mongo queries API Endpoints are placed.
     
    
### API Endpoints

- #### Employee Get Operations using JPA
    > **GET Mapping** http://localhost:8080/employee-jpa  - Get all Employees 
    
    > **GET Mapping** http://localhost:8080/employee-jpa/5f380dece02f053eff29b986  - Get Employee by ID
    
    > **GET Mapping** http://localhost:8080/employee-jpa/firstName/Rahul  - Get All Employees with firstname as Rahul 
    
    > **GET Mapping** http://localhost:8080/employee-jpa/one-by-firstName/Rahul  - Get **ONE** Employee with firstname as Rahul 
    
    > **GET Mapping** http://localhost:8080/employee-jpa/firstName-like/Rahul  - Get All Employees which contains Rahul in their firstname 
    
    > **GET Mapping** http://localhost:8080/employee-jpa/one-by-lastName/Ghadage  - Get **ONE** Employee with lastname as Ghadage 
    
    > **GET Mapping** http://localhost:8080/employee-jpa/salary-greater-than/10000  - Get All Employees whose salary is grater than 1000 
    
    > **POST Mapping** http://localhost:8080/employee-jpa/get-by-condition  - Get All Employees with multiple condition 
                                                           
    Request Body  
    ```
    {
        "id": "5f380dece02f053eff29b986"
        "empId": "1",
        "firstName": "Rahul",
        "lastName": "Khan",
        "salary": 5000
    }
    ``` 

- #### Employee Get Operations using Queries
    > **GET Mapping** http://localhost:8080/employee-query  - Get all Employees 
    
    > **GET Mapping** http://localhost:8080/employee-query/firstName/Rahul  - Get All Employees with firstname as Rahul 
    
    > **GET Mapping** http://localhost:8080/employee-query/one-by-firstName/Rahul  - Get **ONE** Employee with firstname as Rahul 
    
    > **GET Mapping** http://localhost:8080/employee-query/firstName-like/Rahul  - Get All Employees which contains Rahul in their firstname 
    
    > **GET Mapping** http://localhost:8080/employee-query/one-by-lastName/Ghadage  - Get **ONE** Employee with lastname as Ghadage 
    
    > **GET Mapping** http://localhost:8080/employee-query/salary-greater-than/10000  - Get All Employees whose salary is grater than 1000 
    
    > **POST Mapping** http://localhost:8080/employee-query/get-by-condition  - Get All Employees with multiple condition 
                                                           
    Request Body  
    ```
    {
        "id": "5f380dece02f053eff29b986"
        "empId": "1",
        "firstName": "Rahul",
        "lastName": "Khan",
        "salary": 5000
    }
    ``` 
