FROM openjdk

WORKDIR /app

COPY Producer/target/Producer-0.0.1-SNAPSHOT.jar producer.jar

ENTRYPOINT ["java", "-jar", "producer.jar"]