# -------- build stage ------------
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app

# Kopiera pom.xml och ladda dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Kopiera source code och bygg
COPY src ./src
RUN ./mvnw clean package -DskipTests

# --------- runtime stage -------------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Skapa non-root user (valfritt, extra säkerhet)
RUN groupadd -r spring && useradd -r -g spring spring
USER spring:spring

# Kopiera JAR från build stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Health check (valfritt, bra för produktion)
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Starta applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]