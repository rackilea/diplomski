<target name="compile" depends="init" description="Compile the source code and run JiBX binding compiler">
  <mkdir dir="${dest.dir}" />
  <javac srcdir="${src.dir}:${gen.src.dir}" destdir="${dest.dir}" deprecation="on">
    <classpath refid="build.classpath" />
  </javac>
  <bind binding="${gen.src.dir}/xxx-binding.xml">
    <classpath path="${dest.dir}" />
  </bind>
  <bind binding="${wssec.binding.file}">
    <classpath path="${dest.dir}" />
  </bind>
</target>