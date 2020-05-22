#!/bin/bash
#
dir=$(dirname $1)
d=${dir//\//.}
headline=$(head -n1 $1) 
p=${headline#package }
if [[ $d";" != $p ]]
then 
    echo "mismatch: " + $d " " + $p + " " + $1
fi