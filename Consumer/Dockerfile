FROM openjdk

WORKDIR /app

COPY Consumer/target/Consumer-0.0.1-SNAPSHOT.jar consumer.jar

ENTRYPOINT ["java", "-jar", "consumer.jar"]