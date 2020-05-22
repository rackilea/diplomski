<target name="test" depends="compile-tests" description="Run unit tests">
    <mkdir dir="${build.dir}/test-reports"/>
    <junit printsummary="yes" haltonfailure="yes">
        <classpath>
            <path refid="test.path"/>
            <pathelement path="${build.dir}/classes"/>
            <pathelement path="${build.dir}/test-classes"/>
        </classpath>
        <formatter type="xml"/>
        <batchtest fork="yes" todir="${build.dir}/test-reports">
            <fileset dir="${test.src.dir}">
                <include name="**/*Test*.java"/>
                <exclude name="**/AllTests.java"/>
            </fileset>
        </batchtest>
    </junit>
</target>