#!/bin/bash
# MyApp
#
# description:raspberryUtils util service

case $1 in
    start)
        /bin/bash /home/developer/raspberryUtils/bootstartup/startServer.sh
    ;;
    stop)
        /home/developer/raspberryUtils/bootstartup/stopServer.sh
    ;;
    restart)
        /home/developer/raspberryUtils/bootstartup/stopServer.sh
        /home/developer/raspberryUtils/bootstartup/startServer.sh
    ;;
esac
exit 0