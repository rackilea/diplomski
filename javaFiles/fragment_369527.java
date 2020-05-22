if [ "$(ls -A ${WATCHED_DIR})" ]; then
    /etc/init.d/tomcat7 stop
    rm -fr /usr/share/tomcat7/webapps/${WEBAPP_NAME}
    mv ${WATCHED_DIR}/${WEBAPP_NAME}.war /usr/share/tomcat7/webapps/
    chown -R tomcat:tomcat /usr/share/tomcat7/webapps/${WEBAPP_NAME}
    /etc/init.d/tomcat7 start
fi