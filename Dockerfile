# Use an official OpenJDK 17 runtime image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/hookah-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
