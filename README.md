# Medicine Shop Application

## Overview
The Medicine Shop application is a Spring Boot-based RESTful web service that provides functionalities for managing medicines. It includes features for creating, reading, updating, and deleting medicine records, along with OAuth2 security integration for authentication.

## Features
- RESTful API for managing medicines
- OAuth2 authentication for secure access
- MySQL database for persistent storage

## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security (OAuth2)

## Setup Instructions

### Prerequisites
- Java 11 or higher
- Maven
- MySQL Server

### Installation
1. Clone the repository:
   ```
   git clone <repository-url>
   cd medicine-shop
   ```

2. Configure the MySQL database:
   - Create a new database for the application.
   - Update the `src/main/resources/application.properties` file with your database connection details.

3. Build the application:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

### Usage
- The API endpoints can be accessed at `http://localhost:8080/api/medicines`.
- Use OAuth2 tokens for authentication when accessing secured endpoints.

## API Endpoints
- `GET /api/medicines` - Retrieve all medicines
- `GET /api/medicines/{id}` - Retrieve a medicine by ID
- `POST /api/medicines` - Create a new medicine
- `PUT /api/medicines/{id}` - Update an existing medicine
- `DELETE /api/medicines/{id}` - Delete a medicine

## License
This project is licensed under the MIT License.