FROM java:8
VOLUME /tmp
ADD banking.jar banking.jar
RUN bash -c 'touch /banking.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/banking.jar"]