<target name="dist" depends="compile" description="generate the distribution">
    <jar jarfile="target/jarFile.jar" basedir="${build}" update="true">

        <fileset dir="${src}">
            <include name="org/test/images/**/*.png" />
        </fileset>

    </jar>
</target>