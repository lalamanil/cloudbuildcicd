#informing the docker to use maven image
FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#setting the working directory
WORKDIR /build/
#copy the pom.xml into working directory
COPY pom.xml /build/pom.xml
#copy the src into working directory
COPY src /build/src
#Running the maven command to build the package
RUN mvn package -DskipTests
#Informing docker to use jre image to execute the package generated in previous stage
FROM openjdk:17-alpine
#set current working directory 
WORKDIR /app
#copy the artifact generated in previous build 
COPY --from=MAVEN_BUILD /build/target/*.jar /app/finalartifact.jar
#defining the entry point
ENTRYPOINT ["java","-jar","finalartifact.jar"]