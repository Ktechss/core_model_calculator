# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and the pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download the Maven dependencies
RUN ./mvnw dependency:go-offline

# Copy the project files into the container
COPY src src

# Package the application
RUN ./mvnw package -DskipTests

# Verify the contents of the target directory
RUN ls -la target

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "target/CoreCalculator-0.0.1-SNAPSHOT.jar"]
