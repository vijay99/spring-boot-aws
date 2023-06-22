# Use a base image with Java and Maven installed
#FROM adoptopenjdk:11-jre-hotspot
#FROM adoptopenjdk/openjdk17:jre-17.0.0
# Use a base image with Java 17 installed
#FROM adoptopenjdk:17-jre-hotspot
# Use a base image with Java 17 installed
FROM openjdk:17-jdk-slim


# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from your Spring Boot application
COPY target/spring-boot-ecs-0.0.1.jar app.jar

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Set environment variables for PostgreSQL connection
#ENV DB_HOST=jdbc:postgresql://localhost/demo
#ENV DB_HOST=localhost
#ENV DB_PORT=5432
#ENV DB_NAME=demo
#ENV DB_USERNAME=postgres
#ENV DB_PASSWORD=admin

# Install PostgreSQL client
#RUN apt-get update && apt-get install -y postgresql-client

# Set the entry point command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
