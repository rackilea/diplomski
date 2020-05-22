<target name = "stop-webapp">
       <catalina-stop url="${tomcat.manager.url}"
                         username="${tomcat.username}"
                         password="${tomcat.password}"
                         path="/${webapp.name}"
                         failonerror="false"/>
</target>

<target name = "start-webapp">
    <catalina-start url="${tomcat.manager.url}"
                       username="${tomcat.username}"
                       password="${tomcat.password}"
                       path="/${webapp.name}"/>
</target>

<target name = "undeploy-webapp">
    <catalina-undeploy url="${tomcat.manager.url}"
                          username="${tomcat.username}"
                          password="${tomcat.password}"
                          path="/${webapp.name}"
                          failonerror="false"/>
</target>

<target name = "deploy-webapp">
    <catalina-deploy url="${tomcat.manager.url}"
                        username="${tomcat.username}"
                        password="${tomcat.password}"
                        path="/${webapp.name}"
                        war="file:${war.file}"/>
</target>