<jar jarfile="${build.dir}/jar/final.jar">
        <fileset dir="${build.dir}/classes" />
        <zipgroupfileset dir="${lib.dir}" includes="*.jar"/>
        <manifest>
            <attribute name="Main-Class" value="my.pacakge.Main" />
        </manifest>
    </jar>