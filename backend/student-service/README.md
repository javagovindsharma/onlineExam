### Student Service

The **Student Service** is responsible for managing all student-related data within the Student Management System. It provides functionality for creating, updating, retrieving, and deleting student profiles, as well as retrieving basic information needed by other services like Enrollment and Grades.

---

#### Key Features
- **Student Profile Management**: Create, update, and delete student profiles.
- **Retrieve Student Information**: Fetch student details by ID, including contact information and enrollment status.
- **Inter-service Communication**: Provides essential data to other services (e.g., Enrollment, Grades) as needed.

---

#### Technologies Used
- **Spring Boot**: For building the REST API.
- **Spring Data JPA**: For interacting with the database.
- **MySQL/PostgreSQL**: Relational database to store student data.
- **Eureka Client**: For service discovery in a microservices environment.
- **Lombok**: To reduce boilerplate code for models and entities.

---

#### API Endpoints

The **Student Service** exposes the following REST endpoints:

| Method | Endpoint                | Description                                    |
|--------|--------------------------|------------------------------------------------|
| `POST` | `/students`             | Creates a new student profile                  |
| `GET`  | `/students/{id}`        | Retrieves student details by ID                |
| `GET`  | `/students`             | Retrieves a list of all students               |
| `PUT`  | `/students/{id}`        | Updates information for an existing student    |
| `DELETE` | `/students/{id}`      | Deletes a student profile by ID                |

---

#### Sample Request and Response

- **Create a New Student**

  **Request**:
  ```json
  POST /students
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com",
    "contactNumber": "123-456-7890",
    "address": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62704"
    }
  }
  ```

  **Response**:
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com",
    "contactNumber": "123-456-7890",
    "address": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62704"
    },
    "createdDate": "2023-10-20T14:30:00Z"
  }
  ```

- **Get Student Details**

  **Request**:
  ```json
  GET /students/1
  ```

  **Response**:
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com",
    "contactNumber": "123-456-7890",
    "address": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62704"
    },
    "createdDate": "2023-10-20T14:30:00Z"
  }
  ```

---

#### Database Schema

Here’s a sample schema for the `Student` entity:

```sql
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contact_number VARCHAR(15),
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

#### Error Handling

The **Student Service** uses standard HTTP response codes to indicate success or failure:

- **200 OK** - Successful retrieval or update of student data.
- **201 Created** - Successful creation of a new student.
- **400 Bad Request** - Invalid input or missing required fields.
- **404 Not Found** - Student not found for the given ID.
- **500 Internal Server Error** - General server error.

---

#### Usage

To start the Student Service:

1. Ensure the database is running and accessible.
2. Update the `application.yml` with the correct database connection details.
3. Start the service using:

   ```bash
   mvn spring-boot:run
   ```

   Or deploy as a Docker container (if Docker support is configured).

This **Student Service** documentation provides a comprehensive guide for developers and users on how to set up, configure, and interact with the service. Adjust details based on your project specifics if needed.