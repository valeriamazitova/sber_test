# sber_test
Implementation of CRUD-app.

This is a Java project that demonstrates CRUD (Create, Read, Update, Delete) operations on `Person` and `Item` objects using Hibernate. It includes database configuration, session management, and basic data manipulation.


## Prerequisites

To run this project, you'll need the following prerequisites:

- Java Development Kit (JDK)
- Apache Maven (if you're using Maven as your build tool)
- Hibernate and JPA dependencies (usually managed by the build tool)
- PostgreSQL
- JUnit
- Slf4j

## Getting Started

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/valeriamazitova/sber_test
   cd sber_test

2. **Set the configurations:**

    - start Postgres server
    - write in server configurations into hibernate.properties file
    - load initial data using start.sql file
    - see the JavaDoc documentation
    - run app and tests using `mvn clean install` command in the terminal
