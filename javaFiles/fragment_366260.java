<javac srcdir="${test}" destdir="temp/test-build" debug="${debug}" encoding="UTF-8">
        <classpath>
            [...]
            <pathelement location="${build}"/>
        </classpath>
    </javac>