<packager-module version="1.0">
    <property name="name" value="${ivy.packager.module}"/>
    <property name="version" value="${ivy.packager.revision}"/>
    <property name="packagename" value="${name}-${version}"/>

    <resource dest="archive" url="http://jsoup.org/packages/jsoup-1.6.1.jar" sha1="b65281e9d00f255cdfab9e1880f7fc7a1fb1bffb"/>

    <build>
        <jar basedir="archive" destfile="artifacts/jars/${name}.jar"/>
    </build>
</packager-module>