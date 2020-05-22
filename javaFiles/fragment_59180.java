<target name="uberjar" depends="compile">
  <jar jarfile="${babelnet.jar}">
    <fileset dir="${bin.dir}">
      <include name="**/*.class"/>
    </fileset>
    <zipgroupfileset dir="lib" includes="*.jar"/>
    <fileset dir="${basedir}">
      <include name="config/*.properties"/>
    </fileset>
  </jar>
</target>