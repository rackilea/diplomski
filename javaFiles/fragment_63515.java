<target name="compile" depends="resolve,resources" description="Compile code">
    <mkdir dir="${build.dir}/classes"/>
    <javac srcdir="${src.dir}" destdir="${build.dir}/classes" includeantruntime="false" debug="true" classpathref="compile.path"/>
</target>

<target name="compile-tests" depends="compile" description="Compile tests">
    <mkdir dir="${build.dir}/test-classes"/>
    <javac srcdir="${test.src.dir}" destdir="${build.dir}/test-classes" includeantruntime="false" debug="true">
        <classpath>
            <path refid="test.path"/>
            <pathelement path="${build.dir}/classes"/>
        </classpath>
    </javac>
</target>