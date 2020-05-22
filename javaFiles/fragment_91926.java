<target name="dist" depends="compile">

    <mkdir dir="${dist}/lib" />

    <manifest file="${build}/META-INF/MANIFEST.MF">
        <attribute name="Class-Path" value="MyGame.jar" />
        <attribute name="Main-Class" value="game.Game"/>  
    </manifest>

    <jar manifest="${build}/META-INF/MANIFEST.MF" jarfile="${dist}/lib/MyGame.jar" basedir="${build}" />

</target>