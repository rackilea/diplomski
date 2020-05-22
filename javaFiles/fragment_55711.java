<apply executable="pack200" parallel="false" dest="${dir.tomcat.jar}">
        <arg value="--modification-time=latest"/>
        <arg value="--deflate-hint=true"/>
        <arg value="--segment-limit=-1"/>
        <targetfile/>
        <srcfile/>
        <fileset dir="${dir.tomcat.jar}" includes="**/*.jar" />
    <mapper type="glob" from="*" to="*.pack.gz" />
    </apply>