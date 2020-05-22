<path id="runClasspath">
    <pathelement location="${path_to_jasper_libs}"/>
    <pathelement path="${path_to_scriplet}\scriplet.jar"/>
</path>

<taskdef name="jrc" classname="net.sf.jasperreports.ant.JRAntCompileTask"> 
  <classpath refid="classpath"/>
</taskdef>

<target name="compile1"> 
  <mkdir dir="./build/reports"/> 
  <jrc 
    srcdir="./reports"
    destdir="./build/reports"
    tempdir="./build/reports"
    keepjava="true"
    xmlvalidation="true">
   <classpath refid="runClasspath"/>
   <include name="**/*.jrxml"/>
  </jrc>
</target>

<target name="compile2">
  <mkdir dir="./build/reports"/> 
  <jrc 
    destdir="./build/reports"
    tempdir="./build/reports"
    keepjava="true"
    xmlvalidation="true">
   <src>
    <fileset dir="./reports">
     <include name="**/*.jrxml"/>
    </fileset>
   </src>
   <classpath refid="runClasspath"/>
  </jrc> 
</target>