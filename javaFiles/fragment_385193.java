<project name="foo">    
  <property name="cal.out.dir" value="${out.absolute.dir}"/> 
  <target name="print">
  <echo>${cal.out.dir}</echo>
  </target>
</project>