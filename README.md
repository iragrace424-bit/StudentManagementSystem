# Student Registration and Management System

## 1. Project Description
This project is a Student Registration and Management System developed using Java, Spring Boot, Spring MVC, Thymeleaf and PostgreSQL.

It allows users to register students, save their information in a database and view all registered students.

## 2. Technologies Used
- Java 25
- Spring Boot
- Spring MVC
- Thymeleaf
- PostgreSQL
- JDBC
- Maven
- IntelliJ IDEA

## 3. Database Setup

Create a PostgreSQL database named `student_management`.

Create the students table using:

```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(150),
    age INTEGER CHECK (age > 18),
    email VARCHAR(150) UNIQUE
);
```

Configure the database connection in `application.properties` using your database username and the `DB_PASSWORD` environment variable.

## 4. Project Structure
- **Model:** Student.java – represents student information.
- **Controller:** StudentController.java – handles HTTP requests.
- **Service:** StudentService.java – contains business logic.
- **Repository:** StudentRepository.java – communicates with PostgreSQL using JDBC.
- **Templates:** register.html and students.html – display the web pages.

## 5. Main Features
- Register new students.
- Validate student information.
- Reject students below 19 years old.
- Validate email addresses.
- Save student records in PostgreSQL.
- Display all registered students.

## 6. Main URLs
- `/student/register` – Student registration form.
- `/student/all` – Display all registered students.

## 7. Dependency Injection
The project uses constructor-based dependency injection. Spring manages the Controller, Service and Repository components as beans.

The Controller depends on the Service, while the Service depends on the Repository.

## 8. How to Run
1. Create the PostgreSQL database and students table.
2. Configure the database credentials.
3. Set the `DB_PASSWORD` environment variable.
4. Run the main Spring Boot application class.
5. Open `http://localhost:8080/student/register` in a browser.