<!-- 
        Delete files: .faces-config.xml.jsfdia and .pages.xml.spdia which are created after
        editing faces-config.xml and pages.xml files in /resources/WEB-INF catalogue. 
        Files: .faces-config.xml.jsfdia and .pages.xml.spdia cause that deployment 
        cycle goes into an infinite loop. 
    -->
    <delete>
        <fileset dir="${basedir}/resources/WEB-INF">
            <include name=".faces-config.xml.jsfdia"/>
            <include name=".pages.xml.spdia"/>
        </fileset>
    </delete>


It is a part of build.xml file:

<target name="war" depends="compile"
    description="Build the WAR structure in a staging directory">
            <delete>
        <fileset dir="${basedir}/resources/WEB-INF">
            <include name=".faces-config.xml.jsfdia"/>
            <include name=".pages.xml.spdia"/>
        </fileset>
    </delete>
    <!-- delete element should be in this XML element: target .... then is a lot of   
     code -->
 </target>