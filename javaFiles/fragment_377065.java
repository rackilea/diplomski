FROM java:8
ARG app_version

RUN echo -------------------
RUN echo "App Version: ${app_version}"
RUN echo -------------------

VOLUME /tmp
COPY ./build/libs/mango-sticky-rice-1.0.0-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'

RUN echo "#!/bin/bash \n java -Dapp-version=${app_version} -jar /app.jar" > ./entrypoint.sh
RUN chmod +x ./entrypoint.sh

RUN cat ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]