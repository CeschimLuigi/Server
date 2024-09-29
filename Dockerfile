# Etapa de build
FROM maven:3.9.4-amazoncorretto-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
# Corrigido o caminho para o JAR
COPY --from=build /app/target/server-0.0.1-SNAPSHOT.jar /app/saborsolidario.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/saborsolidario.jar"]
