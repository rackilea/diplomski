<path id="myclasspath">
  <fileset dir="${dir.path}">
    <include name="*.jar"/>
  </fileset>
</path>
...

<javac destdir="${build.dir}">
  <src path="${src.dir}"/>
  <classpath refid="myclasspath"/>
</javac>