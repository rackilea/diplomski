<target name="changeVersion">

    <xmltask source="${src.file}" dest="${dest.file}" preserveType="true" >
        <replace path="/ivy-module/info/@revision" withText="${target.version}" />
        <replace path="/ivy-module/dependencies/dependency[@name='my-common']/@rev"       withText="${target.version}" /> 
<replace path="/ivy-module/dependencies/dependency[@name='my-gui-common']/@rev" withText="${target.version}" /> 
        </xmltask>  
        <fixcrlf file="${src.file}" eol="cr" />
    </target>