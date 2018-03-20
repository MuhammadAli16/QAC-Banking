FROM java:8
VOLUME /tmp
ADD movie.jar movie.jar
RUN bash -c 'touch /movie.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/movie.jar"]