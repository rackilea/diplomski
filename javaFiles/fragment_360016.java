$ while true ; do
    java -jar task1.jar &
    java -jar task2.jar &
    wait
    sleep 600
  done