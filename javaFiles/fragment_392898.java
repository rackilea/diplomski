#!/bin/bash -x
PROPERTIES=/opt/jboss/application.properties
echo "db_url = jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT" > ${PROPERTIES}
echo "db_username = ${MYSQL_USER}" >> ${PROPERTIES}
echo "db_password = ${MYSQL_PASS}" >> ${PROPERTIES}
exec /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 $@