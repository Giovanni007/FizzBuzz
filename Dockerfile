FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} gf-fizz-buzz.jar
ENTRYPOINT ["/opt/java/openjdk/bin/java", "-jar", "bin/[artifactId].jar"]
