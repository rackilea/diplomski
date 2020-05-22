<target name="go">      
    <property name="batFileDir" location="${basedir}/resources" />

    <exec executable="cmd" dir="." spawn="false">
        <arg line="/C start ${batFileDir}/runTool.bat"/>
    </exec>                
</target>