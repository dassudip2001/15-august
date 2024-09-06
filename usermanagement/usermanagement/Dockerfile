# First stage: Build the application
FROM ubuntu:22.04 AS build

# Install Java and Maven
RUN apt-get update && apt-get install -y openjdk-21-jdk maven

# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application
RUN mvn clean package -DskipTests

# Second stage: Run the application using Java 21
FROM eclipse-temurin:22-jre-alpine

# Copy the jar file from the first stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]