# Etapa de build
FROM maven:3.9.4-amazoncorretto-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*server.jar /saborsolidario.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/saborsolidario.jar"]
