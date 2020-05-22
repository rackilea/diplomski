<target name="makeQuery">
    <java classname="sparkDemo.SparkTest" failonerror="true">
        <classpath>
            <pathelement location="${basedir}/spark-de.jar"/>
            <pathelement location="${basedir}/lib1.jar"/>
            <pathelement location="${basedir}/lib2.jar"/>
        </classpath>
    </java>
</target>