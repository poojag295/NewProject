FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN mvn clean package -Dskip-tests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
