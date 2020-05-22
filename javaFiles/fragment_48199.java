<target name="-post-jar">
     <mkdir dir="${dist.dir}/resources"/>
     <copy todir="${dist.dir}/resources">
         <fileset dir="${basedir}/resources" />
     </copy>
 </target>