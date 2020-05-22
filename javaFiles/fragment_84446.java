<batchtest fork="yes" todir="${target-test-reports}" >
    <fileset dir="${target-test-classes}">
        <include name="**/*Test*.class"/>
    </fileset>
    <formatter type="xml"/>
    <formatter type="plain" usefile="false" />
</batchtest>