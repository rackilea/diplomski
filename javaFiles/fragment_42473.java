#!/usr/bin/ksh

if [ "$1" = "-test" ]
then
   echo "Test"
   script_arg=( "${@}" )
   for i in "${script_arg[@]}"
   do
     echo "One of the arguments is: $i"
   done
fi

java -jar test.jar "${script_arg[@]}"