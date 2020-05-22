<war destfile="${build.dir}/${ant.project.name}_${version}.war" webxml="${web.dir}/WEB-INF/web.xml">
    <webinf dir="${web.dir}/WEB-INF">
        <exclude name="web.xml"/>
        <exclude name="classes/**"/>
        <exclude name="lib/**"/>
        <exclude name="flex/services-config.xml"/>
    </webinf>
    <lib dir="${war.web-inf.dir}/lib"/>
    <lib file="${build.dir}/*.jar"/>
    <fileset dir="${web.dir}">
        <include name="img/*"/>
    </fileset>