### Attendance Service

---

## Attendance Service

The Attendance Service is responsible for tracking and managing student attendance for courses. It allows teachers to mark attendance, retrieve attendance records, and generate attendance reports for students, ensuring a comprehensive record of student participation.

### Features
- **Mark Attendance**: Allows teachers to mark students as present or absent for a specific class session.
- **View Attendance Records**: Enables retrieval of attendance records for individual students or for entire courses.
- **Generate Attendance Reports**: Provides functionality to generate detailed reports based on attendance data.

### API Endpoints

The Attendance Service exposes the following RESTful API endpoints:

| Method | Endpoint                         | Description                                      |
|--------|----------------------------------|--------------------------------------------------|
| POST   | `/attendance`                   | Mark attendance for a student in a course.      |
| GET    | `/attendance/{courseId}`        | Get attendance records for a specific course.   |
| GET    | `/attendance/student/{studentId}`| Get attendance records for a specific student.   |
| GET    | `/attendance/report/{studentId}`| Generate attendance report for a specific student. |
| DELETE | `/attendance/{studentId}/{courseId}`| Remove attendance entry for a specific student in a course.|

### Request and Response Examples

#### 1. Mark Attendance

- **Request**:
    - **Method**: `POST`
    - **Endpoint**: `/attendance`
    - **Body**:
      ```json
      {
        "courseId": "12345",
        "studentId": "67890",
        "date": "2024-10-26",
        "status": "present" // or "absent"
      }
      ```

- **Response**:
    - **Status**: `201 Created`
    - **Body**:
      ```json
      {
        "message": "Attendance marked successfully",
        "attendanceId": "abcde12345"
      }
      ```

#### 2. Get Attendance for a Course

- **Request**:
    - **Method**: `GET`
    - **Endpoint**: `/attendance/{courseId}`

- **Response**:
    - **Status**: `200 OK`
    - **Body**:
      ```json
      {
        "courseId": "12345",
        "attendanceRecords": [
          {
            "studentId": "67890",
            "date": "2024-10-26",
            "status": "present"
          },
          {
            "studentId": "54321",
            "date": "2024-10-26",
            "status": "absent"
          }
        ]
      }
      ```

### Usage

1. **Setting Up Attendance Service**:
    - Ensure the Attendance Service is running alongside other microservices in the Student Management System.
    - Configure the service properties in `application.yml` or `application.properties`, including database connection details.

2. **Integrating with Other Services**:
    - The Attendance Service can be integrated with the **Student Service** to fetch student details and with the **Course Service** to validate course information.

3. **Testing**:
    - Use tools like Postman or curl to test the API endpoints. Ensure to set appropriate headers such as `Content-Type: application/json`.

4. **Error Handling**:
    - The service provides meaningful error responses for invalid requests, such as missing required fields or invalid student/course IDs.

### Conclusion

The Attendance Service plays a crucial role in managing and monitoring student attendance, helping educators keep track of student participation effectively. This service integrates seamlessly with the overall architecture of the Student Management System, ensuring a cohesive experience for users.

---

Feel free to modify this content to fit the specific implementation details and features of your Attendance Service. This section can be placed in the main README file under the appropriate heading for clarity.