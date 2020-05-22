#!/bin/sh
filename=$1

var = $filename | sed 's/\([A-Z]\)/ \1/g';

echo var;