# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM maven:3.8.6-openjdk-11 AS build

WORKDIR /app
COPY . /app/
RUN nvm clean package


FROM openjdk:11-alpine
WORKDIR  /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
