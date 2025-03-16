FROM gradle:8.13.0-jdk21-corretto AS builder

WORKDIR /app

COPY . .

RUN ./gradlew build -x test

EXPOSE 8081

CMD ls

SHELL ["/bin/bash", "-c"]
CMD ["java", "-jar", "./build/libs/demo-nginx-0.0.1-SNAPSHOT.jar"]

## Second stage: Create a smaller runtime image
#FROM openjdk:21-jdk-alpine
#
#WORKDIR /app
#
## Copy the built JAR from the builder stage
#COPY --from=builder /app/build/libs/demo-nginx-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8081
#
#CMD ["java", "-jar", "app.jar"]