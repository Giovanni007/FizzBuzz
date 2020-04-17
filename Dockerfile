FROM openjdk:alpine

EXPOSE 8080

ADD target/fizz_buzz_mvn_plugin.jar fizz_buzz_mvn_plugin.jar

ENTRYPOINT [ "java", "-jar", "fizz_buzz_mvn_plugin.jar" ]