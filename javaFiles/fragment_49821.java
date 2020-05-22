<target name="war" depends="mklib, retrieve, compile">
    <war destfile="${war.file}" webxml="${webContent.dir}/WEB-INF/web.xml">
        <classes dir="${classes.dir}" />
        <classes dir="${src.dir}" includes="**/start.xml, **/per*.xml, **/*.sql" />
        <fileset dir="${webContent.dir}" excludes="**/servlet-api*.jar,**/jsp-api*.jar" />
    </war>
</target>