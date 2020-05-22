<javac srcdir="${test}" destdir="temp/test-build" debug="${debug}" encoding="UTF-8">
        <classpath>
            [...]
            <fileset dir="${build}"/>
        </classpath>
    </javac>