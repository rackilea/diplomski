#!/bin/bash

files="$@"

for i in $files;
do
    echo "Doing $i"
    java -jar somefile.jar <<< "$i"
done