<target name="-post-jar">
    <copy todir="${jnlp.dest.dir}/lib/">
        <fileset dir="${build.dir}/../lib/">
            <filename name="swt*.jar" />
        </fileset>
    </copy>

</target>