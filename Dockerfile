
FROM openjdk:8-jdk-alpine
EXPOSE 9019
COPY /target/packsendme-google-api-server-0.0.1-SNAPSHOT.jar packsendme-google-api-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/packsendme-google-api-server-0.0.1-SNAPSHOT.jar"]