FROM php:7.0-apache

ENV LANG C.UTF-8
RUN { \
        echo '#!/bin/sh'; \
        echo 'set -e'; \
        echo; \
        echo 'dirname "$(dirname "$(readlink -f "$(which javac || which java)")")"'; \
    } > /usr/local/bin/docker-java-home \
    && chmod +x /usr/local/bin/docker-java-home
RUN ln -svT "/usr/lib/jvm/java-8-openjdk-$(dpkg --print-architecture)" /docker-java-home
ENV JAVA_HOME /docker-java-home/jre
ENV JAVA_VERSION 8u212
ENV JAVA_DEBIAN_VERSION 8u212-b01-1~deb9u1
RUN set -ex; \
    if [ ! -d /usr/share/man/man1 ]; then \
        mkdir -p /usr/share/man/man1; \
    fi; \
    apt-get update; \
    apt-get install -y --no-install-recommends openjdk-8-jre-headless="$JAVA_DEBIAN_VERSION"; \
    rm -rf /var/lib/apt/lists/*; \
    [ "$(readlink -f "$JAVA_HOME")" = "$(docker-java-home)" ]; \
    update-alternatives --get-selections | awk -v home="$(readlink -f "$JAVA_HOME")" 'index($3, home) == 1 { $2 = "manual"; print | "update-alternatives --set-selections" }'; \
    update-alternatives --query java | grep -q 'Status: manual'

COPY ["./build/libs/*.jar", "./FooBar.jar"]
ENV JAVA_OPTS=${FOO_JAVA_OPTS}

COPY gui/src /var/www/html
EXPOSE 80