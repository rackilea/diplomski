<structure name="JaCoCo Ant Example">
        <classfiles>
            <fileset dir="${result.classes.dir}">
                <exclude name="**/*Test*.class"/>
            </fileset>
        </classfiles>
        <sourcefiles encoding="UTF-8">
            <fileset dir="${src.dir}" />
        </sourcefiles>
</structure>