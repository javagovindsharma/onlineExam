# Authentication Service

The **Authentication Service** is a critical component of the Student Management System, responsible for managing user authentication and authorization. This service handles user registration, login, token generation, and role-based access control, ensuring that only authorized users can access certain functionalities of the system.

### Features

- **User Registration**: Allows new users (students and teachers) to register and create their profiles.
- **Login**: Authenticates users and generates JWT (JSON Web Tokens) for secure session management.
- **Token Validation**: Validates JWT tokens for protected routes.
- **Role Management**: Supports role-based access control to restrict access to specific services based on user roles (e.g., admin, student, teacher).
- **Logout**: Handles user logout and token invalidation.

### API Endpoints

Here are the main API endpoints exposed by the Authentication Service:

#### User Registration
- **Endpoint**: `POST /auth/register`
- **Description**: Register a new user (student or teacher).
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string",
    "role": "string"  // roles: "student", "teacher", "admin"
  }
  ```
- **Response**:
    - **201 Created**: User registered successfully.
    - **400 Bad Request**: Validation errors.

#### User Login
- **Endpoint**: `POST /auth/login`
- **Description**: Authenticate a user and return a JWT token.
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response**:
    - **200 OK**: Returns the JWT token.
    - **401 Unauthorized**: Invalid credentials.

#### Token Validation
- **Endpoint**: `GET /auth/validate`
- **Description**: Validates the provided JWT token.
- **Headers**:
    - `Authorization: Bearer <token>`
- **Response**:
    - **200 OK**: Token is valid.
    - **401 Unauthorized**: Invalid or expired token.

#### User Logout
- **Endpoint**: `POST /auth/logout`
- **Description**: Logs out the user and invalidates the token.
- **Headers**:
    - `Authorization: Bearer <token>`
- **Response**:
    - **200 OK**: Successfully logged out.

### Usage

1. **Register a User**: Send a POST request to `/auth/register` with user details to create a new account.
2. **Login**: Use the `/auth/login` endpoint to authenticate and receive a JWT token.
3. **Access Protected Resources**: Include the JWT token in the Authorization header for requests to other services that require authentication.
4. **Logout**: Call the `/auth/logout` endpoint to invalidate the token upon user logout.

### Example Requests

#### User Registration
```bash
curl -X POST http://localhost:8080/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"john.doe", "password":"password123", "role":"student"}'
```

#### User Login
```bash
curl -X POST http://localhost:8080/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"john.doe", "password":"password123"}'
```

### Security Considerations

- Passwords should be stored securely using strong hashing algorithms (e.g., BCrypt).
- Ensure HTTPS is used for all requests to protect sensitive data in transit.
- Implement rate limiting and account lockout mechanisms to prevent brute-force attacks.

---

This section provides comprehensive information about the Authentication Service, including its purpose, API endpoints, usage instructions, and security considerations. You can adjust the content according to your specific implementation and requirements.