#!/bin/sh
restartCode="1"; # predefined restart signal code
java -jar '/home/fdqadmin/NetBeansProjects/dbConvert2/dist/dbConvert2.jar' --Terminal=true; # run java program
if [ $? -eq restartCode ] # if exit code is equal to predefined restart signal code
then
  $0; # restart script
fi
exit $?;