<target name="filter-sources">
    <copy todir="${build.dir}/src">
       <fileset dir="src/templates" includes="**/*.java"/>
       <filterset>
          <filter token="WS_NAMESPACE" value="${ws.namespace}"/>
       </filterset>
    </copy>
</target>

<target name="compile" depends="filter-sources">
    <javac destdir="${build.dir}/classes">
        <src path="src/java"/>
        <src path="${build.dir}/src"/>
        <classpath>
        ..
        ..
    </javac>
</target>