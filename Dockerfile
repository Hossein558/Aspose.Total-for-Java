# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /build

COPY pom.xml .
COPY src/ ./src/
COPY aspose-agent.jar .
COPY Aspose.TotalforJava.lic .

# Download dependencies and compile
RUN mvn clean compile dependency:copy-dependencies -DoutputDirectory=target/libs

# Runtime Stage
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /build/target/classes /app/classes
COPY --from=builder /build/target/libs /app/libs
COPY aspose-agent.jar /app/
COPY Aspose.TotalforJava.lic /app/

ENV JAVA_TOOL_OPTIONS="-javaagent:/app/aspose-agent.jar"

CMD ["java", "-cp", "/app/classes:/app/libs/*", "com.example.AsposeLicenseTester"]
