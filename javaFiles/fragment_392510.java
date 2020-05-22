#!/bin/bash
cd your-dir
for i in *
do
#get the absolute path; be careful, realpath comes with the latest coreutils package
    r=$(realpath "$i")
    #to be not disturb by relative path with java -jar, I put the .jar in the parent directory
    cd ..
    java -jar owl2rdf.jar "$r"
    cd your-dir
done
echo "Conversion finished, see below if there are errors."