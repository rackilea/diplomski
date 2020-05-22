<path id="catalina-ant-classpath">
    <fileset dir="${appserver.lib}">
           <include name="catalina-ant.jar"/>
           <include name="tomcat-coyote.jar"/>
           <include name="tomcat-util.jar"/>
        </fileset>
    <fileset dir="${appserver.home}/bin">
               <include name="tomcat-juli.jar"/>
    </fileset>
</path>