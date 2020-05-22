<target name="-post-jfx-deploy">
<fx:deploy width="${javafx.run.width}" height="${javafx.run.height}" 
          nativeBundles="all"
          outdir="${basedir}/${dist.dir}" outfile="${application.title}">
  <fx:application name="${application.title}" 
                  mainClass="${javafx.main.class}"/>
  <fx:resources>
      <fx:fileset dir="${basedir}/${dist.dir}"
                  includes="*.jar"/>
  </fx:resources>
  <fx:info title="${application.title}" 
           vendor="${application.vendor}"/>
</fx:deploy>