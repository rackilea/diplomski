<target name="package" depends="test" description="Create the WAR file">
    <ivy:retrieve pattern="${build.dir}/lib/[artifact].[ext]" conf="runtime"/>

    <war destfile="${war.file}" webxml="${resources.dir}/web.xml">
        <fileset dir="${resources.dir}" excludes="web.xml"/>
        <lib dir="${build.dir}/lib"/>
    </war>
</target>