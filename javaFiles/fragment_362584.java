<javac
    debug="${javac.debug}"
    deprecation="${javac.deprecation}"
    destdir="${build.classes.dir}"
    encoding="${source.encoding}"
    excludes="${excludes}"
    executable="${platform.javac}"
    fork="yes"
    includeantruntime="false"
    includes="${includes}"
    source="${javac.source}"
    sourcepath="${empty.dir}"
    srcdir="${srcdir}"
    target="${javac.target}"
    tempdir="${java.io.tmpdir}">
    <src>
       <dirset dir="${empty.dir}"
            erroronmissingdir="false">
            <include name="*"/>
       </dirset>
   </src>
   <classpath>
       <path path="${javac.classpath"/>
   </classpath>
   <compilerarg line="${endorsed.classpath.cmd.line.arg}"/>
   <compilerarg line="${javac.compilerargs}"/>
   <customize/>