<jar destfile="${dist}/lib/app1.jar">
   <fileset dir=".">
    <includesfile name="app1.properties"/>
   </fileset>
  </jar>
 <jar destfile="${dist}/lib/app2.jar">
   <fileset dir=".">
    <includesfile name="app2.properties"/>
   </fileset>
  </jar>