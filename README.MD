# Spring Boot Tutorial

This is a Spring Boot tutorial by Sorravit featuring RESTful APIs with MySQL database integration.

## Getting Started

### Prerequisites
- Java 21
- Gradle
- Docker (for MySQL database)

### Database Setup
To start the MySQL database:
```shell
sh run.sh start_database
```
### Running Database Migrations
```shell
sh run.sh database_migrate

```
### Running the Application
```shell
./gradlew bootRun
```

## API Documentation

### Hello World API
Simple hello world REST API endpoint.

```shell
# Get hello world message
curl http://localhost:8080/hello
```

### Product API
CRUD operations for managing products.

#### Get All Products
```shell
curl http://localhost:8080/api/products
```

#### Get Product by ID
```shell
curl http://localhost:8080/api/products/1
```

#### Create New Product
```shell
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Sample Product",
    "price": 99.99
  }'
```

#### Update Product
```shell
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Product",
    "price": 149.99
  }'
```

#### Delete Product
```shell
curl -X DELETE http://localhost:8080/api/products/1
```

## Database Schema

### Product Table
```sql
CREATE TABLE product(
    id SERIAL PRIMARY KEY,
    name varchar(255),
    price double precision
);
```

## Running Tests
```shell
./gradlew test
```

## Built With
- Spring Boot 3.5.4
- MyBatis
- Flyway for database migrations
- MySQL
- Lombok
- SpringDoc OpenAPI UI for API documentation

## API Documentation UI
Access the Swagger UI for interactive API documentation:
```
http://localhost:8080/swagger-ui/index.html
```
