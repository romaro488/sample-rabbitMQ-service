FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine
COPY ["target/sender-1.0-SNAPSHOT.jar", "app.jar"]
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=docker /app.jar" ]