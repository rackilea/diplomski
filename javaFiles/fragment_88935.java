#!/bin/bash
#
# tomcat
#
# chkconfig:
# description:  Start up the Tomcat servlet engine.

# Source function library.
. /etc/init.d/functions


RETVAL=$?
CATALINA_HOME="/usr/apps/apache/tomcat/jakarta-tomcat-4.0.4"

case "$1" in
 start)
        if [ -f $CATALINA_HOME/bin/startup.sh ];
          then
      echo $"Starting Tomcat"
            /bin/su tomcat $CATALINA_HOME/bin/startup.sh
        fi
  ;;
 stop)
        if [ -f $CATALINA_HOME/bin/shutdown.sh ];
          then
      echo $"Stopping Tomcat"
            /bin/su tomcat $CATALINA_HOME/bin/shutdown.sh
        fi
  ;;
 *)
  echo $"Usage: $0 {start|stop}"
  exit 1
  ;;
esac