<target name="run" depends="compile" description="run the project">
    <java dir="${build.dir}" classname="${main.class}" fork="yes">
        <arg line="${args}"/>
        <arg file="testFile.txt"/>
    </java>
</target>