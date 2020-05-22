FROM sonarqube:7.8-community

COPY plugins /opt/sonarqube/extensions/plugins
COPY openjdk-11.0.3.tar.gz .

USER root

RUN \
tar -xvzf openjdk-11.0.3.tar.gz -C /usr/local && \ 
rm -rf openjdk-11.0.3.tar.gz 

ENV JAVA_HOME /usr/local/java-11-openjdk-11
ENV PATH="$JAVA_HOME/bin:${PATH}"