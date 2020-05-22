<target name="compile" depends="init" description="compile the source code " >
  <javac srcdir="${src}" destdir="${build}">
    <classpath>
      <fileset dir="lib">
        <include name="**/*.jar"/>
      </fileset>
    </classpath>
  </javac>
  <javac srcdir="${tests}" destdir="${build}">
    <classpath>
      <pathelement path="${build}"/>
      <fileset dir="lib">
        <include name="**/*.jar"/>
      </fileset>
    </classpath>
  </javac>
</target>