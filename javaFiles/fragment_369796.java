<target name= "run" depends = "jar">
        <java fork='yes' jar="build/jar/KnightsTour.jar" >
                <arg value="${rows}"/>
                <arg value="${columns}"/>
                <arg value="${attempts}"/>
        </java>
    </target>