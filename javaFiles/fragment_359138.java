#!/bin/ksh
while read line.
do
  user=${line%%=*}
  ip=${line##*=}
  # example how to access the values
  printf "user: %s  IP: %s\n" "${user}" "${ip}"
done < your.properties