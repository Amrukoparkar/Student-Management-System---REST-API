# 🎓 Student Management System - Backend REST API

A RESTful API for managing student records built with Spring Boot, Spring Data JPA, and MySQL.

**Note:** This is a backend-only project focused on robust API development.

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- MySQL 8.0
- Maven
- Lombok

---

## ✨ Features

- Create, Read, Update, Delete operations
- Search students by name
- Filter students by age range
- Global exception handling
- Input validation
- RESTful API design
- CORS support

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/students` | Create student |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get by ID |
| GET | `/api/students/email/{email}` | Get by email |
| GET | `/api/students/search/name?name={name}` | Search by name |
| GET | `/api/students/age-range?min={min}&max={max}` | Filter by age |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete by ID |
| DELETE | `/api/students/delete-all` | Delete all |
| GET | `/api/students/count` | Get total count |

### Example Request

**Create Student:**
```json

POST /api/students
{
  "rollno": "S001",
  "name": "Amruta Koparkar",
  "email": "amruta@example.com",
  "age": 21
}


Response:

json
{
  "id": 1,
  "rollno": "S001",
  "name": "Amruta Koparkar",
  "email": "amruta@example.com",
  "age": 21
}

🗄️ Database Schema

sql

CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rollno VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT NOT NULL
);


🚀 Getting Started

Prerequisites

Java 17+
MySQL 8.0+
Maven

Steps

Clone the repository

bash

git clone https://github.com/yourusername/student-management-api.git

Create database

sql

CREATE DATABASE student_crud_db;

Update application.properties with your MySQL password

Build and run

bash

mvn clean install
mvn spring-boot:run

Test the API

bash

curl http://localhost:8080/api/students

🧪 Testing with cURL

bash

# Create student
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"rollno":"S001","name":"John Doe","email":"john@example.com","age":25}'

# Get all students
curl http://localhost:8080/api/students

# Get by ID
curl http://localhost:8080/api/students/1

# Update student
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{"rollno":"S001","name":"John Updated","email":"john.updated@example.com","age":26}'

# Delete student
curl -X DELETE http://localhost:8080/api/students/1


📁 Project Structure

text
src/
├── main/
│   ├── java/in/Student/CURD/
│   │   ├── controller/StudentController.java
│   │   ├── service/StudentService.java
│   │   ├── service/impl/StudentServiceImpl.java
│   │   ├── repository/StudentRepository.java
│   │   ├── model/Student.java
│   │   └── exception/
│   │       ├── ResourceNotFoundException.java
│   │       └── GlobalExceptionHandler.java
│   └── resources/application.properties
└── test/


📊 Error Handling

Exception	Status
ResourceNotFoundException	404 Not Found
MethodArgumentNotValidException	400 Bad Request
Exception	500 Internal Server


Error Response:

json
{
  "status": 404,
  "message": "Student not found with id: 1",
  "timestamp": "2026-08-13T14:00:00",
  "details": "uri=/api/students/1"
}


🚀 Future Enhancements


□ Add JWT Authentication
□ Implement Swagger/OpenAPI
□ Add Unit Tests
□ Docker containerization
□ Add caching (Redis)
□ Deploy to cloud


🤝 Connect

📧 Email: amrutakoparkar1@gmail.com
🔗 LinkedIn: www.linkedin.com/in/amruta-koparkar-415862294


⭐ Support
If you found this helpful, please ⭐ this repository!
Built with ❤️ by Amruta Koparkar | Final Year Student

