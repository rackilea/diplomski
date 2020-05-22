#!/usr/bin/env bash
while :
do
    echo "waiting for user to exist"
    if $(/bin/bash /check_db_user.sh | grep -q XYZ); then
        echo "user XYZ exists"
        exit 0
    fi
done