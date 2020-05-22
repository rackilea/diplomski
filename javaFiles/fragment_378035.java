<project name="myproject" basedir="." default="all">

<property name="build.dir" value="${basedir}/build"/>
<property name="dist.dir" value="${basedir}/dist"/>
<property name="src.dir" value="${basedir}/src"/>
<property name="jar.name" value="myjar.jar"/>
<property name="classes.dir" value="${build.dir}/classes"/>
<property file="${basedir}/build.properties"/>

<target name="all" depends="clean, compile, jar, run"/>

<target name="clean" description="cleans all build directories">
    <delete dir="${build.dir}"/>
</target>

<target name="compile" description="compiles the project">
    <mkdir dir="${classes.dir}"/>
    <javac srcdir="${src.dir}" destdir="${classes.dir}" debug="on" deprecation="on" optimize="on" fork="true" memoryMaximumSize="256m">
        <include name="**/*.java"/>
    </javac>
</target>

<target name="jar" description="Jars the files and signs the jar file">
    <jar jarfile="${build.dir}/${jar.name}">
        <manifest>
            <attribute name="Built-By" value="${user.name}"/>
        </manifest>
        <fileset dir="${classes.dir}">
            <include name="**/*.*"/>
        </fileset>
    </jar>
</target>

<target name="run" description="runs tasks">
    <echo>Running task 1</echo>
     <java classname="test.Main1">
     <classpath>
       <pathelement location="${build.dir}/${jar.name}"/>
     </classpath>
   </java>
   <echo>Running task 2</echo>
   <java classname="test.Main2">
     <classpath>
       <pathelement location="${build.dir}/${jar.name}"/>
     </classpath>
   </java>
</target>
</project>