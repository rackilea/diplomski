<target name="tomcat-start">
    <java jar="${tomcat.home}/bin/bootstrap.jar" fork="true">
        <jvmarg value="-Dcatalina.home=${tomcat.home}"/>
    </java>
</target>

<target name="tomcat-stop">
    <java jar="${tomcat.home}/bin/bootstrap.jar" fork="true">
        <jvmarg value="-Dcatalina.home=${tomcat.home}"/>
        <arg line="stop"/>
    </java>
</target>