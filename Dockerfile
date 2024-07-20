# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/Banking-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8585

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"]