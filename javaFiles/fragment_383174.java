{
        "label": "debug on server",
        "type": "shell",
        "command": "export MAVEN_OPTS='-Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000';mvn tomcat7:run",
        "group": "test"
}