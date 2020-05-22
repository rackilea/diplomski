IP=`ifconfig eth0  | grep 'inet '| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}'``;

CATALINA_OPTS="-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.ssl=false
-Dcom.sun.management.jmxremote.authenticate=TRUE
-Dcom.sun.management.jmxremote.password.file=$CATALINA_HOME/conf/jmxremote.password
-Dcom.sun.management.jmxremote.access.file=$CATALINA_HOME/conf/jmxremote.access
-Djava.rmi.server.hostname=$IP"