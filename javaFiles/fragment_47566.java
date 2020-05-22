#!/bin/bash

#file that has a list of all server IPs that need the temp folder cleaned
server_lists=/etc/server_lists

#command to clean temp with chromium directories created prior to 30 minutes
cmd='echo "Clean temp"; find  /tmp/ -maxdepth 1  -mmin +30 -iname ".org.chromium*" -type d  -exec rm -rf "{}" \; && echo Done'

for ip in $( < $server_lists )
do

   ssh -o StrictHostKeyChecking=no $ip "$cmd" 

done