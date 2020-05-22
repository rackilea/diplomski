<target name="test" depends="build.modules" >
    <junit haltonerror="yes" haltonfailure="yes">
        <classpath>
            <pathelement location="${basedir}/lib/junit-4.12.jar"/>
            <pathelement location="${basedir}/lib/hamcrest-core-1.3.jar"/>
            <pathelement location="${pearplanner.output.dir}/"/>
            <pathelement location="${pearplanner.testoutput.dir}/"/>
        </classpath>
        <batchtest>
            <fileset dir="${pearplanner.testoutput.dir}">
                <include name="**/*Test*" />
            </fileset>
        </batchtest>
        <formatter type="brief" usefile="false"/>
    </junit>
</target>