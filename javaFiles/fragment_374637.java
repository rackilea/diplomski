FROM alpine:latest
USER root

RUN apk update
RUN apk fetch openjdk8
RUN apk add openjdk8
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"

RUN java -version
RUN javac -version