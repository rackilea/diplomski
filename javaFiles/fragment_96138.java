<target name="unexplode" description="Undeploy the exploded archive">
        <delete failonerror="no">
            <fileset dir="${ear.deploy.dir}">
                <exclude name="**/*.jar"/>
            </fileset>
        </delete>
        <delete file="${deploy.dir}/${project.name}-ds.xml" failonerror="no"/>
        <delete dir="${ear.deploy.dir}" failonerror="no"/>
</target>