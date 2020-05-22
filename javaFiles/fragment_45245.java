#!/bin/sh

file="test.txt"
[ -f "$file" ] && rm -f "$file"

# you want to store the output of gphoto2 in a variable
# var=$(gphoto2 --summary)
# problem 1: what if PATH environment variable is wrong (i.e. gphoto2 not accessible)?
# problem 2: what if gphoto2 outputs to stderr?
# it's better first to:
if ! type gphoto2 > /dev/null 2>&1; then
    echo "gphoto2 not found!" >&2
    exit 1
fi
# Why using var?...
gphoto2 --summary > "$file" 2>&1
# if you insert any echo here, you will alter $?
if [ $? -eq 0 ]; then
    echo "Successfully created file"
    exit 0
else
    echo "Could not create file" >&2
    exit 1
fi