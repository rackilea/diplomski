<target name="build"
    description="Builds every sub project">
    <ant antfile=${project.a.dir}/build.xml target="build"/>
    <ant antfile=${project.b.dir}/build.xml target="build"/>
    <ant antfile=${project.c.dir}/build.xml target="build"/>
    <ant antfile=${project.d.dir}/build.xml target="build"/>