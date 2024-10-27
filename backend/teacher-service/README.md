
## Teacher Service

The **Teacher Service** is responsible for managing teacher profiles within the Student Management System. This service allows administrators to create, read, update, and delete teacher information, as well as assign teachers to courses. It plays a crucial role in ensuring that the system can track teachers' details and their associated courses efficiently.

### Features

- **Manage Teacher Profiles**: Create, update, and delete teacher information.
- **Course Assignments**: Assign teachers to specific courses, enabling a clear mapping between teachers and the subjects they teach.
- **Query Teacher Details**: Retrieve details of teachers based on their unique identifiers.

### Endpoints

Below are the available API endpoints for the Teacher Service:

| Method | Endpoint            | Description                         |
|--------|---------------------|-------------------------------------|
| **POST**   | `/teachers`        | Create a new teacher profile       |
| **GET**    | `/teachers`        | Retrieve a list of all teachers    |
| **GET**    | `/teachers/{id}`   | Retrieve details of a teacher by ID |
| **PUT**    | `/teachers/{id}`   | Update an existing teacher profile  |
| **DELETE** | `/teachers/{id}`   | Delete a teacher profile            |
| **GET**    | `/teachers/courses/{courseId}` | Get all teachers assigned to a specific course |

### Data Model

The following JSON schema represents the Teacher model:

```json
{
  "id": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "phone": "string",
  "department": "string",
  "courses": [
    {
      "courseId": "string",
      "courseName": "string"
    }
  ]
}
```

### Example Requests

#### Create a New Teacher

```http
POST /teachers
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phone": "+1234567890",
  "department": "Mathematics"
}
```

#### Get Teacher Details by ID

```http
GET /teachers/{id}
```

#### Update a Teacher's Profile

```http
PUT /teachers/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@updated.com",
  "phone": "+1234567890",
  "department": "Mathematics"
}
```

#### Delete a Teacher

```http
DELETE /teachers/{id}
```

### Running the Teacher Service

1. **Clone the Repository**: Make sure you have cloned the main repository containing the Teacher Service.
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   cd student-management-system/teacher-service
   ```

2. **Configure the Database**: Update the `application.yml` or `application.properties` file with your database configuration.

3. **Run the Service**:
   ```bash
   mvn spring-boot:run
   ```

### Notes

- Ensure that the service is running and the database is properly set up before testing the endpoints.
- Use tools like Postman or cURL to interact with the API endpoints.

---

### Conclusion

The Teacher Service is a vital component of the Student Management System, providing essential functionalities for managing teacher information and course assignments. Make sure to integrate it with the other microservices to fully utilize the features of the system.

---

Feel free to modify this content as needed to fit your specific implementation details, configurations, or requirements.