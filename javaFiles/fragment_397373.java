<concat destfile="${file.flyway.sql.concat}" outputencoding="UTF-8"append="true">
    <sort xmlns:rcmp="antlib:org.apache.tools.ant.types.resources.comparators">
        <fileset refid="dir.set.flyway.db.version.build"/>
        <rcmp:name />
    </sort>
</concat>