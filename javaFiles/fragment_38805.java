<java classname="org.mozilla.javascript.tools.shell.Main" failonerror="true">
    <arg path="${src.dir}/r-js/dist/r.js" />
    <arg value="-o"/>
    <arg path="${src.dir}/r-js/build.js" />
    <classpath>
        <pathelement location="${src.dir}/r-js/lib/rhino/js.jar" />
        <pathelement location="${src.dir}/r-js/lib/closure/compiler.jar" />
    </classpath>
</java>