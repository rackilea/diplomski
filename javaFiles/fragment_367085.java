<path id="jars">
    <fileset dir="${lib.dir}" includes="**/*.jar"/>
</path>

<target name="compile">
    <mkdir dir="${build.dir}"/>
    <javac srcdir="${src.dir}" destdir="${build.dir}" classpathref="jars" debug="on"/>
</target>