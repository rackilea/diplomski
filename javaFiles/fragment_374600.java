<target name="test_passing_params">
    <antcall target="test_echo">
        <param name="param1" value=";;;"/>
        <param name="param2" value="{"/>
    </antcall>
</target>
<target name="test_echo">
    <echo>param1: ${param1}</echo>
    <echo>param2: ${param2}</echo>
</target>