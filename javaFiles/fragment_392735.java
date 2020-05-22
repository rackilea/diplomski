<target name="-post-jar">
  <exec executable="cmd.exe" dir="${dist.dir}">
    <arg value="/k"/>
    <arg value='start "MyApp" java -jar ${dist.jar}'/>
  </exec>
</target>