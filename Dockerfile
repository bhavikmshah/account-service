#using openjdk 10 as base image
FROM openjdk:10
COPY target/account-service.jar /account-service.jar
CMD ["java", "-jar","/account-service.jar"]
EXPOSE 8004