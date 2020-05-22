<junit showoutput="true"
       fork="true"
       failureproperty="tests.failed"
       errorproperty="tests.failed">
    <batchtest todir="${test.results.dir}">
        <fileset dir="test">
            <include name="**/*Test.java"/>
        </fileset>
    </batchtest>
    <classpath path="${classes.dir}:${junit.jar}:${test.classes.dir}"/>
    <formatter usefile="false" type="brief"/>
    <!-- <formatter type="xml"/> If missing, only displays failed tests -->
</junit>