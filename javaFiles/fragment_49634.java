FROM anapsix/alpine-java:jdk8

ENV MAVEN_VERSION 3.3.3

RUN apk update && apk upgrade && apk add curl wget bash tar rsync openssh-client

RUN mkdir -p /usr/share/maven \
  && curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz \
    | tar -xzC /usr/share/maven --strip-components=1 \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn \
  && rm -rf /tmp/* /var/cache/apk/*;

ENV MAVEN_HOME /usr/share/maven

ENTRYPOINT []
CMD ["bash"]