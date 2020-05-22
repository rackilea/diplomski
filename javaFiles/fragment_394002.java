<target name="compile">
    <mkdir dir="${classes.dir}"/>
    <javac srcdir="${src.dir}" destdir="${classes.dir}">
        <classpath>
               <fileset dir="${lib}">
                  <include name="**/*.jar" />
               </fileset>
         </classpath>
    </javac>
</target>

<target name="jar" depends="compile">
    <mkdir dir="${jar.dir}"/>
    <jar destfile="${jar.dir}/${ant.project.name}.jar" basedir="${classes.dir}">
        <manifest>
            <attribute name="Main-Class" value="${main-class}"/>
        </manifest>
        <zipgroupfileset dir="${lib}" includes="**/*.jar"/>
    </jar>

</target>