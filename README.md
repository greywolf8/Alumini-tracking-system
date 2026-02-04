# Alumni Management System

A comprehensive Spring Boot-based web application for managing alumni information, featuring a RESTful API backend and an interactive frontend interface.

## 🚀 Features

- **CRUD Operations**: Complete Create, Read, Update, Delete functionality for alumni records
- **RESTful API**: Well-designed REST API with proper HTTP methods and status codes
- **Interactive Frontend**: Bootstrap-based web interface for easy management
- **Database Integration**: MySQL database with JPA/Hibernate ORM
- **Validation**: Input validation and error handling
- **CORS Support**: Configured for cross-origin requests

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.1.0**
- **Spring Data JPA**
- **Spring Web**
- **Spring Validation**
- **MySQL Connector**
- **Maven**

### Frontend
- **HTML5**
- **Bootstrap 5.3.0**
- **JavaScript (ES6+)**
- **CSS3**

### Database
- **MySQL 8.0**

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher
- Git

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/greywolf8/Alumini-tracking-system.git
cd Alumini-tracking-system
```

### 2. Database Setup
Create a MySQL database named `alumni_db` or configure the database settings in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/alumni_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Access the Application
- **API Base URL**: `http://localhost:8080/api/v1/alumni`
- **Web Interface**: `http://localhost:8080`

## 📡 API Endpoints

### Alumni Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/alumni` | Get all alumni records |
| GET | `/api/v1/alumni/{id}` | Get alumni by ID |
| POST | `/api/v1/alumni` | Create new alumni |
| PUT | `/api/v1/alumni/{id}` | Update alumni by ID |
| DELETE | `/api/v1/alumni/{id}` | Delete alumni by ID |

### Request/Response Examples

#### Create Alumni
```json
POST /api/v1/alumni
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "batchYear": 2020,
    "department": "Computer Science"
}
```

#### Response
```json
{
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "batchYear": 2020,
    "department": "Computer Science",
    "createdAt": "2023-06-15T10:30:00.000+00:00"
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/example/alumnimanagement/
│   │   ├── AlumniManagementApplication.java    # Main application class
│   │   ├── config/
│   │   │   └── WebConfig.java                  # Web configuration
│   │   ├── controller/
│   │   │   └── AlumniController.java           # REST API controller
│   │   ├── dto/
│   │   │   └── AlumniDto.java                  # Data Transfer Object
│   │   ├── entity/
│   │   │   └── Alumni.java                     # JPA Entity
│   │   ├── exception/
│   │   │   ├── GlobalExceptionHandler.java     # Global exception handler
│   │   │   └── ResourceNotFoundException.java  # Custom exception
│   │   ├── repository/
│   │   │   └── AlumniRepository.java           # JPA Repository
│   │   └── service/
│   │       └── AlumniService.java              # Business logic
│   └── resources/
│       ├── static/
│       │   └── index.html                      # Web interface
│       └── application.properties              # Application configuration
```

## ⚙️ Configuration

### Application Properties
The application can be configured through `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/alumni_db
spring.datasource.username=root
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# CORS Configuration
cors.allowed-origins=http://localhost:8080,http://127.0.0.1:8080
cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
```

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

## 📝 Development

### Adding New Features
1. Create/update entities in the `entity` package
2. Implement repository interfaces in the `repository` package
3. Add business logic in the `service` package
4. Create REST endpoints in the `controller` package
5. Update the frontend interface if needed

### Code Style
- Follow Java naming conventions
- Use proper package structure
- Add meaningful comments
- Handle exceptions appropriately

## 🔧 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure MySQL server is running
   - Check database credentials in `application.properties`
   - Verify database exists

2. **Port Already in Use**
   - Change server port in `application.properties`
   - Kill existing Java processes using the port

3. **CORS Issues**
   - Check CORS configuration in `WebConfig.java`
   - Verify allowed origins in application properties

### Logs
Check application logs for detailed error information:
```bash
mvn spring-boot:run
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Contact

For any queries or support, please reach out to:
- GitHub: [@greywolf8](https://github.com/greywolf8)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap for the responsive UI components
- MySQL for the robust database solution
