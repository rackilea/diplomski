<project name="coverage-merge" basedir="." default="all">
    <!-- directory that contains emma.jar and emma_ant.jar: -->
    <property name="emma.dir" value="${basedir}/lib"/>
    <property name="coverage.dir" location="${basedir}/coverage"/>

    <path id="emma.lib">
        <pathelement location="${emma.dir}/emma-teamcity-3.1.1.jar"/>
        <pathelement location="${emma.dir}/emma_ant-2.0.5312.jar"/>
    </path>

    <taskdef resource="emma_ant.properties" classpathref="emma.lib"/>

    <target name="all" depends="-report"/>

    <target name="-report">
        <emma>
            <report sourcepath="${src.dir}" sort="+block,+name,+method,+class" 
                    metrics="method:70,block:80,line:80,class:100">
                <infileset dir="${coverage.dir}" includes="**/*.em, **/*.ec"/>

                <!-- for every type of report desired, configure a nested
                     element; various report parameters
                     can be inherited from the parent <report>
                     and individually overridden for each report type:
                -->
                <txt outfile="${coverage.dir}/coverage.txt" depth="package" 
                        columns="class,method,block,line,name"/>
                <xml outfile="${coverage.dir}/coverage.xml" depth="package"/>
                <html outfile="${coverage.dir}/coverage.html" depth="method" 
                        columns="name,class,method,block,line"/>
            </report>
        </emma>
    </target>
</project>