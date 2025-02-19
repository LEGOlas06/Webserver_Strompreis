FROM maven:3.9.5-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/Webserver_Dynamisch-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080mvn clean package -DskipTests

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
