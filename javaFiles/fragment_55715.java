<target name="createjars"
  depends="compile"
  description="Jars the compiled classes">
    <mkdir dir="${build}/jar/" />

    <foreach target="jar.package" param="package" inheritall="true">
        <path>
            <dirset dir="${src}/java/org/pscode" includes="**/*" />
        </path>
    </foreach>
</target>