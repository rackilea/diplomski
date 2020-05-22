<target name="jar">
    <mkdir dir="${jar.dir}" />
    <manifestclasspath property="manifest.classpath"
                       jarfile="${jar.dir}/App.jar">
      <classpath refid="classpath" />
    </manifestclasspath>
    <jar destfile="${jar.dir}/App.jar" basedir="${classes.dir}">
        <manifest>
            <attribute name="Main-Class" value="main.App" />
            <attribute name="Class-Path" value="${manifest.classpath}" />.
        </manifest>
    </jar>
</target>