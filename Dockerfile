FROM openjdk:8
ADD target/e-reservation.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/e-reservation.jar"]
EXPOSE 8090