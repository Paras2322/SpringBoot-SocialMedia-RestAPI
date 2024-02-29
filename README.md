# Social Media REST API

## Overview

This project implements a REST API for a social media platform, offering endpoints for user management, post creation, and retrieval. Below are the services and features provided by the API:

## Services Provided

### General Exception Handling

The API includes robust exception handling mechanisms to gracefully handle unexpected errors and provide informative error messages to clients. This ensures a smooth user experience and helps in troubleshooting issues effectively.

### Custom Response Builder

Custom response messages are generated for different API endpoints and operations, ensuring consistency and clarity in the API responses. This allows clients to easily interpret the response and take appropriate actions based on the outcome of their requests.

### Implementing Validations in REST API

Input validations are implemented using Bean Validation annotations (`@Valid`) to enforce data integrity and prevent invalid requests. This ensures that the API receives valid data and avoids potential errors or inconsistencies in the database.

### Swagger

Swagger UI is integrated into the API to provide interactive documentation for the endpoints. This allows developers to explore and test the API easily without relying on external documentation. Swagger also helps in understanding the request and response formats required for each endpoint.

### MySQL

The API uses MySQL as the underlying relational database to store user information and posts. MySQL is a widely used database management system known for its reliability, scalability, and performance, making it suitable for storing social media data.

### Spring Data JPA

Spring Data JPA is utilized for database operations, providing convenient repository interfaces for CRUD (Create, Read, Update, Delete) operations on entities. Spring Data JPA simplifies database access by abstracting away the boilerplate code required for database interactions, resulting in cleaner and more maintainable code.

### Content Negotiation Implementing Support for XML

The API supports content negotiation, allowing clients to request responses in either JSON or XML format based on their preferences. Content negotiation enhances interoperability by accommodating different client requirements and ensuring flexibility in data exchange formats.

### Internationalization for REST API

Internationalization (i18n) support is implemented to provide responses in multiple languages based on client preferences. This allows the API to cater to users from diverse linguistic backgrounds and enhance the user experience by delivering content in their preferred language.

### HATEOAS

Hypermedia as the Engine of Application State (HATEOAS) is implemented to provide navigation links along with API responses. HATEOAS enables clients to discover and navigate related resources dynamically, reducing coupling between clients and servers and improving the overall API usability.

### HAL (Hypertext Application Language)

HAL is implemented to represent API resources in a standardized hypermedia format, providing a consistent and uniform way to structure API responses. HAL enables clients to understand the relationships between resources and navigate the API seamlessly.

### Actuator

Spring Boot Actuator is integrated into the API to monitor and manage the application's health, metrics, and other useful information. Actuator endpoints expose valuable insights into the application's runtime behavior, facilitating operational tasks such as monitoring, troubleshooting, and performance optimization.

### Security

Basic authentication security is implemented to restrict access to certain endpoints and ensure data privacy. By requiring authentication, the API ensures that only authorized users can access sensitive resources, protecting user data from unauthorized access or tampering.

## Getting Started

To run the Social Media REST API locally, follow these steps:

1. Clone the repository to your local machine.
2. Configure the MySQL database connection in the `application.yml` file.
3. Run the application using Maven or your preferred IDE.
4. Access the API endpoints using a REST client like Postman or through the Swagger UI documentation.

## API Endpoints

### Users

- **GET /users**: Retrieve all users.
- **GET /user/{userId}**: Retrieve a specific user by ID.
- **POST /user**: Create a new user.
- **PUT /user**: Update an existing user.
- **DELETE /user/{userId}**: Delete a user by ID.

### Posts

- **GET /user/{userId}/posts**: Retrieve all posts of a specific user.
- **GET /users/posts**: Retrieve all posts from all users.
- **POST /user/{userId}/posts**: Create a new post for a specific user.

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter HATEOAS
- Spring Boot Starter Validation
- Springdoc OpenAPI Starter Webmvc UI
- Jackson Dataformat XML
- Jakarta XML Bind API
- JAXB Runtime
- Spring Boot Starter Data JPA
- MySQL Connector J
- Spring Boot Starter Actuator
- Spring Boot DevTools
- Project Lombok

## Contributors

- [Paras Bagga]


