<junit printsummary="yes" haltonfailure="yes">
    <classpath>
        <pathelement location="${build.tests}"/>
        <pathelement path="${java.class.path}"/>
    </classpath>

    <formatter type="plain"/>

    <test name="my.test.TestCase" haltonfailure="no" outfile="result">
        <formatter type="xml"/>
    </test>

    <batchtest fork="yes" todir="${reports.tests}">
        <fileset dir="${src.tests}">
            <include name="**/*Test*.java"/>
            <exclude name="**/AllTests.java"/>
        </fileset>
    </batchtest>
</junit>