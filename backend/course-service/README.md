### Course Service

The **Course Service** is a microservice responsible for managing course-related operations within the Student Management System. This service handles the creation, retrieval, updating, and deletion of course information. It also manages associations between courses and instructors, schedules, and other course-related metadata.

---

#### Key Features

- **Course Management**: Add, update, view, and delete courses.
- **Course Catalog**: Maintain a catalog of available courses, searchable by different criteria.
- **Instructor Association**: Link courses to specific instructors.
- **Schedule Management**: Manage course schedules, including start/end dates, and class timings.
- **Integration with Enrollment Service**: Ensures only available courses can be enrolled in.

---

#### Technologies Used

- **Java** with **Spring Boot** for developing the microservice.
- **Spring Data JPA** for managing course-related data in a relational database (e.g., MySQL or PostgreSQL).
- **Eureka Client** (Optional) for service discovery in a microservices environment.
- **Spring Cloud Gateway** (via API Gateway) for routing requests to the Course Service.

---

#### API Endpoints

Here’s a list of the primary API endpoints for the Course Service:

| HTTP Method | Endpoint                | Description                                 |
|-------------|--------------------------|---------------------------------------------|
| `POST`      | `/courses`               | Create a new course                         |
| `GET`       | `/courses`               | Retrieve a list of all courses              |
| `GET`       | `/courses/{id}`          | Get details of a specific course by ID      |
| `PUT`       | `/courses/{id}`          | Update course details                       |
| `DELETE`    | `/courses/{id}`          | Delete a course by ID                       |
| `GET`       | `/courses/search`        | Search for courses based on various filters |

---

#### Data Model

The Course Service uses the following data model for storing course information:

- **Course ID** (UUID): Unique identifier for each course.
- **Course Name**: Name of the course.
- **Description**: Brief summary of what the course covers.
- **Duration**: Length of the course in hours or weeks.
- **Start Date / End Date**: Start and end dates for the course.
- **Instructor ID**: Identifier linking the course to an instructor.
- **Capacity**: Maximum number of students allowed to enroll.

---

#### Sample API Requests

##### Create a New Course
```http
POST /courses
Content-Type: application/json

{
  "courseName": "Introduction to Computer Science",
  "description": "A foundational course in computer science principles",
  "duration": "12 weeks",
  "startDate": "2024-01-15",
  "endDate": "2024-04-15",
  "instructorId": "123e4567-e89b-12d3-a456-426614174000",
  "capacity": 30
}
```

##### Get a Course by ID
```http
GET /courses/{id}
```

##### Update a Course
```http
PUT /courses/{id}
Content-Type: application/json

{
  "courseName": "Advanced Computer Science",
  "description": "In-depth study of algorithms and data structures",
  "duration": "14 weeks",
  "startDate": "2024-02-01",
  "endDate": "2024-05-15",
  "instructorId": "123e4567-e89b-12d3-a456-426614174000",
  "capacity": 25
}
```

---

#### Configuration

- **Database**: Configure database settings (e.g., URL, username, password) in `application.yml` or `application.properties`.
- **Eureka Client**: Enable Eureka if using service discovery. Set `eureka.client.serviceUrl.defaultZone` to your Eureka server URL.

  ```yaml
  eureka:
    client:
      serviceUrl:
        defaultZone: http://localhost:8761/eureka/
  ```

- **Port Configuration**: Set a specific port for the Course Service if necessary.

  ```yaml
  server:
    port: 8081
  ```

---

#### Running the Service

1. **Clone the repository** and navigate to the Course Service module:
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   cd student-management-system/course-service
   ```

2. **Start the service**:
   ```bash
   mvn spring-boot:run
   ```

3. **Access the API**:
   After starting, the Course Service API will be available at `http://localhost:8081` (or the configured port).

---

This documentation provides a full overview of the **Course Service**, covering its purpose, endpoints, sample requests, and configuration. It should help other developers or users understand and integrate the Course Service into the Student Management System.