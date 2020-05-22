<javac srcdir="${test-unit.dir}" destdir="${target-test-classes.dir}" 
        classpathref="test.classpath" source="1.6" target="1.6" debug="true" 
        includeAntRuntime="false" compiler="org.eclipse.jdt.core.JDTCompilerAdapter">
    <compilerclasspath location="./libs/ecj-3.7.2.jar" />
    <compilerarg line="-time -properties .settings/org.eclipse.jdt.core.prefs" />
</javac>