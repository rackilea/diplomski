#! /bin/sh
case "$1" in
start)   /usr/local/jakarta/tomcat/bin/startup.sh ;;    
stop)    /usr/local/jakarta/tomcat/bin/shutdown.sh ;;
restart) /bin/sh $0 stop
/bin/sh $0 start ;;
*)   echo "Usage: $0 {start|stop}"
exit 1 ;;
esac