<target name="init">
    <concat destfile="temp/bigPropertiesFile.properties" fixlastline="true">
        <fileset dir="${propertiesDir}" includes="*.properties"/>
    </concat>
    <property file="temp/bigPropertiesFile.properties"/>
</target>