<target name="build"
    description="Builds every sub project">

    <outofdate>
       <sourcefiles>
           <fileset dir="${project.a.srcdir}"/>
       </sourcefiles>
       <targetfiles>
           <fileset dir="${project.a.dir}/target">
              <include name="*.jar"/>
           </fileset>
       </targetfiles>
       <sequential>
           <ant antfile=${project.a.dir}/build.xml
               target="build"/>
       </sequential>
    </outofdate>

    <outofdate>
       <sourcefiles>
           <fileset dir="${project.b.srcdir}"/>
       </sourcefiles>
       <targetfiles>
           <fileset dir="${project.a.dir}/target">
              <include name="*.jar"/>
           </fileset>
       </targetfiles>
       <sequential>
           <echo>CALLING PROJECT: ${project.b.dir}</echo>
           <ant antfile=${project.b.dir}/build.xml
               target="build"/>
       </sequential>
    </outofdate>

    <etc, etc, etc/>