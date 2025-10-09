# Use OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy jar file from target directory to app
COPY target/producer-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","/app/app.jar"]
