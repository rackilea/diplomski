#!/bin/bash
inputFolder=$1
outputFolder=$2 

cd $inputFolder

for file in `ls ` ; do
/usr/local/bin/ffmpeg -i $inputFolder/$file -ar 22050 $outputFolder/$file.mp4 
done