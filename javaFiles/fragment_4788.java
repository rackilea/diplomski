#!/bin/bash
for k in $( seq 3 39 ); do
    java -jar elki.jar KDDCLIApplication \
        -dbc.in whatever \
        -algorithm clustering.kmeans.KMedoidsEM \
        -kmeans.k $k \
        -resulthandler ResultWriter -out.gzip \
        -out output/k-$k 
done