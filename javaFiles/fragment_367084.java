<path id="build.classpath">
    <fileset dir="${basedir}/">
        <include name="${lib.dir}/*.jar"/>
    </fileset>
</path>

<pathconvert property="mf.classpath" pathsep=" ">
    <path refid="build.classpath"/>
    <mapper>
        <chainedmapper>
            <flattenmapper/>
            <globmapper from="*.jar" to="lib/*.jar"/>
        </chainedmapper>
    </mapper>
</pathconvert>