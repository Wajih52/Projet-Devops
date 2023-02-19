# Use an OpenJDK Runtime as a parent image
From openjdk: 8-jre-alpine
# Copy the executable into the container at /app
ADD target/*.jar app.jar
# Make port 9090 available to the world outside this container
EXPOSE 9090
# Run app.jar when the container launches
CMD ["java", "-jar", "/app.jar"]