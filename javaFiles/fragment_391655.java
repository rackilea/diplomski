#!/bin/sh

while true ; do
  java -XX:+ExitOnOutOfMemoryError -jar application.jar
  sleep 5
done