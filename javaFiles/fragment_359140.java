#!/bin/sh
# the file input from file `your.properties` is redirected to filedescriptor 3
# to avoid problems with programs inside the loop which themself use `stdin`
# for reading input
while read user <&3; read ip <&3
do
  user=${user##*=}
  ip=${ip##*=}
  # example how to access the values
  printf "user: %s  ip: %s\n" "${user}" "${ip}"
done 3< your.properties