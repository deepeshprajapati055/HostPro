# RoomHotel

A Spring Boot application for hotel room management and booking system.

## Features

- Room management (add, update, delete rooms)
- Room booking and reservation system
- Room availability checking
- Booking history tracking

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven
- Thymeleaf (for server-side templating)

## Prerequisites

- Java 17 or higher
- Maven
- MySQL

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/deepeshprajapati055/RoomHotel.git
   ```

2. Configure MySQL database:
   - Create a new database named `roomhotel`
   - Update `application.properties` with your database credentials

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:9092`

## Project Structure

- `src/main/java` - Contains Java source files
- `src/main/resources` - Contains application properties and templates

## Contributing

Feel free to fork the repository and submit pull requests.

