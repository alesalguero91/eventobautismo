FROM amazoncorretto:8-alpine-jdk
MAINTAINER salguero
COPY target/backevent-0.0.1-SNAPSHOT.jar  backev.jar
ENTRYPOINT ["java","-jar","/backev.jar"]

