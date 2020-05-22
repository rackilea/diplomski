<path id="production.class.path">
    <pathelement location="${production.classes}"/>
    <pathelement location="${production.resources}"/>
    <fileset dir="${production.lib}">
        <include name="**/*.jar"/>
    </fileset>
</path>

<path id="test.class.path">                            
    <path refid="production.class.path"/>
    <pathelement location="${test.classes}"/>
    <pathelement location="${test.resources}"/>
    <fileset dir="${test.lib}">
        <include name="**/*.jar"/>
    </fileset>
</path>