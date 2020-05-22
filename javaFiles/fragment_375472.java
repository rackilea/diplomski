<target name="buildProject" description="Builds the individual project">
    <exec dir="${source.dir}\${projectName}" executable="cmd">
        <arg value="/C"/>
        <arg value="${env.MAVEN_HOME}\bin\mvn.bat"/>
        <arg line="clean install" />
</exec>
</target>