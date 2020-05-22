<jar destfile="${store.dir}/temp_final.jar" filesetmanifest="skip">
    <zipgroupfileset dir="dist" includes="*.jar"/>
    <zipgroupfileset dir="dist/lib" includes="*.jar" excludes=""/>

    <manifest>
        <attribute name="Main-Class" value="${main.class}"/>
        <attribute name="Class-Path" value="${mf.classpath}"/>
    </manifest>
</jar>