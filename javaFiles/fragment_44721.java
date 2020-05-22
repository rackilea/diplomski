<!-- publish javadoc -->
<target name="javadoc" description="Creates javadoc for IMP.">
      <delete dir="${web-javadoc}"/>
      <javadoc sourcepath="${source}"
               defaultexcludes="no"
               destdir="${web-javadoc}"
               author="true"
               version="true"
               use="true"
               windowtitle="IMP: Integrated Mechanisms Program"
               overview="${source}/overview.html"
               classpathref="debug.classpath"
               stylesheetfile="${javadoc-theme}/stylesheet.css"
       />

       <copy file="${javadoc-theme}/javadoc.jpg" tofile="${web-javadoc}/javadoc.jpg"/>
</target>