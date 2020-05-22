FROM java:8

# Install Scala
ENV SCALA_HOME /usr/local/share/scala
ENV PATH $PATH:$SCALA_HOME/bin

ENV SCALA_VERSION 2.11.8

RUN wget --quiet http://downloads.lightbend.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz && \
tar -xf scala-$SCALA_VERSION.tgz && \
rm scala-$SCALA_VERSION.tgz && \
mv scala-$SCALA_VERSION $SCALA_HOME

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src
RUN ["mvn", "package"]

RUN ["java", "-version"]

RUN ["mkdir", "/raw"]
RUN ["chmod", "a+w", "/raw"]
RUN ["mkdir", "/classfiles"];
RUN ["mkdir", "/out"];
EXPOSE 4567
CMD ["mvn", "exec:java"]