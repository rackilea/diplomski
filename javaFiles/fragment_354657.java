<target name="test" depends="compile-tests">
    <echo>Running unit tests, output should be in ${junit.output}</echo>
    <junit printsummary="yes">
        <classpath>
            <pathelement path="${compile.classpath}" />
            <pathelement path="${lib.dir}/junit-4.0.jar" />
            <pathelement path="${build}" />
            <pathelement path="${dist-classes}" />
        </classpath>

        <formatter type="xml" />

        <batchtest fork="yes" todir="${junit.output}">
            <fileset dir="${src.test}">
                <include name="**/*Test.java" />
            </fileset>
        </batchtest>
    </junit>

    <mkdir dir="${DropLocation}/${BuildNumber}/test_results" />
    <junitreport todir="${junit.output}">
        <fileset dir="${junit.output}">
            <include name="TEST-*.xml" />
        </fileset>
        <report todir="${DropLocation}/${BuildNumber}/test_results" />
    </junitreport>
</target>