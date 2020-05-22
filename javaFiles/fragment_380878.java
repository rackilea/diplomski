version: '3.2'

services:

  unit:
    image: openjdk:8-jdk
    volumes:
      - ..:/usr/test
      - gradlecache:/root/.gradle/
    working_dir: /usr/test
    command: sh -c "exec ./gradlew junitPlatformTest -Punit -p moduleA/"
volumes:
  gradlecache: {}