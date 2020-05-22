<path id="classpath">
    <fileset dir="${lib}">
        <include name="**/*.jar"/>
    </fileset>
</path>

<target name="init" depends="clean" description="starts">
    <tstamp/>
</target>

<target name="clean" depends="package-to-jar" description="clean up">
    <delete dir="${classes}"/>
    <delete file="${external-lib}"/>
</target>

<target name="package-to-jar" depends="package-external-lib" description="packing all project into a jar-file">
    <jar destfile="${jar}/${ant.project.name}.jar" basedir="${classes}">
        <manifest>
            <attribute name="Main-Class" value="${main-class}"/>
        </manifest>
        <zipfileset src="${external-lib}"/>
    </jar>
    <delete dir="${classes}"/>
    <delete file="${external-lib}"/>
</target>

<target name="package-external-lib" depends="compile" description="packing external libraries into a jar-file">
    <jar destfile="${external-lib}">
        <zipgroupfileset dir="${lib}">
            <include name="**/*.jar"/>
        </zipgroupfileset>
    </jar>
</target>

<target name="compile" description="compile the source">
    <mkdir dir="${classes}"/>
    <javac srcdir="${src}" destdir="${classes}" classpathref="classpath"/>
    <copy todir="${classes}">
        <fileset dir="${src}" excludes="**/*.java"/>
    </copy>
</target>