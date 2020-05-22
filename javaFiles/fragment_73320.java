$ cat /tmp/test.sh 
#!/bin/bash

for sig in SIGINT SIGTERM SIGHUP; do
  trap "echo Caught $sig" $sig
done

echo Traps registered, sleeping
sleep 10
echo Done sleeping, exiting