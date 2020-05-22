#! /bin/bash

if [ $# -ne 5 ]; then
    echo "usage $0: <arg1> <arg2> <arg3> <arg4> <arg5>"
    exit 1
fi

java ­-cp myjar.jar javaClassName $1 $2 $3 $4 $5