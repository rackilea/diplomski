<target name="compile" depends=""   description="compile the java source files">  
 <javac srcdir="." destdir="${build}">  
    <classpath>  
        <fileset dir="${lib}">  
            <include name="**/*.jar" />  
        </fileset>  
    </classpath>  
</javac>