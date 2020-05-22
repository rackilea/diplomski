<yuicompressor todir="${basedir}/js/" verbose="true">
    <fileset dir="${basedir}/js/" 
        includes="**/*.js"> 
    </fileset>
    <mapper type="glob" from="*.js" to="*.js" />
</yuicompressor>