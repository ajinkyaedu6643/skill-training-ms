# Skill Training Management System

A full-stack REST API backend built with Java Spring Boot for managing a skill training institute — handling students, courses, enrollments, attendance, and payments.

## 🌐 Live Demo
Base URL: `https://skill-training-ms-production.up.railway.app`

Test the API:
- GET /api/dashboard/stats
- GET /api/students
- GET /api/courses

## 🛠️ Tech Stack
- Java 21
- Spring Boot 4.0
- Spring Data JPA + Hibernate
- PostgreSQL
- Spring Security
- Maven
- Deployed on Railway

## 📦 Modules
- **Student** — Add, view, update, delete students
- **Course** — Manage training courses
- **Enrollment** — Enroll students into courses
- **Attendance** — Mark and track attendance with percentage
- **Payment** — Record fees and track payment status
- **Dashboard** — Summary stats (total students, revenue, enrollments)

## 🔌 API Endpoints

### Students
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| POST | /api/students | Add new student |
| DELETE | /api/students/{id} | Delete student |

### Courses
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/courses | Get all courses |
| GET | /api/courses/{id} | Get course by ID |
| POST | /api/courses | Add new course |
| DELETE | /api/courses/{id} | Delete course |

### Enrollments
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/enrollments | Get all enrollments |
| POST | /api/enrollments/student/{sid}/course/{cid} | Enroll student |
| GET | /api/enrollments/student/{id} | Get by student |
| GET | /api/enrollments/course/{id} | Get by course |

### Attendance
| Method | Endpoint | Description |
|---|---|---|
| POST | /api/attendance/enrollment/{id} | Mark attendance |
| GET | /api/attendance/student/{id} | Get by student |
| GET | /api/attendance/percentage/enrollment/{id} | Get percentage |

### Payments
| Method | Endpoint | Description |
|---|---|---|
| POST | /api/payments/enrollment/{id} | Record payment |
| GET | /api/payments/student/{id} | Get by student |
| GET | /api/payments/total/enrollment/{id} | Get total paid |

### Dashboard
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/dashboard/stats | Get summary stats |

## 🚀 Run Locally

### Prerequisites
- Java 21
- PostgreSQL
- Maven

### Steps
1. Clone the repo
git clone https://github.com/ajinkyaedu6643/skill-training-ms.git

2. Create database
createdb skilltraining
3. Update `src/main/resources/application.properties`
spring.datasource.url=jdbc:postgresql://localhost:5432/skilltraining
spring.datasource.username=your_username
spring.datasource.password=your_password

4. Run the app
5. Test at `http://localhost:8081/api/dashboard/stats`

## 👨‍💻 Author
Ajinkya Gaikwad  
Technology Analyst | Java Backend Developer  
[LinkedIn](https://linkedin.com/in/your-profile)
# Skill Training Management System 
