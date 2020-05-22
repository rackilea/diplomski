<path id="master-classpath">
  <fileset dir="${web.dir}/WEB-INF/lib">
    <include name="*.jar"/>
  </fileset>

  <fileset dir="${appserver.lib}">
    <include name="servlet*.jar"/>
  </fileset>

  <pathelement path="${build.dir}"/>
</path>

...

<javac destdir="${build.dir}">
  <src path="${src.dir}"/>
  <classpath refid="master-classpath"/>
</javac>