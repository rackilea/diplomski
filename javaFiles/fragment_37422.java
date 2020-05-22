<target name="wsimport-client-ChartDataService" depends="wsimport-init">
  <mkdir dir="${build.generated.dir}/jax-wsCache/ChartDataService"/>
  <wsimport sourcedestdir="${build.generated.dir}/jax-wsCache/ChartDataService"   destdir="${build.generated.dir}/jax-wsCache/ChartDataService" wsdl="${basedir}/${conf-dir}xml-resources/web-service-references/ChartDataService/wsdl/dev_8080/flower/analysis/ChartDataService.wsdl" extension="true" verbose="true" wsdlLocation="http://dev:8080/flower/analysis/ChartDataService?wsdl" xnocompile="true" xendorsed="true" package="name.justinthomas.flower.analysis.services.ChartData">
    <depends file="${basedir}/${conf-dir}xml-resources/web-service-references/ChartDataService/wsdl/dev_8080/flower/analysis/ChartDataService.wsdl"/>
    <produces dir="${build.generated.dir}/jax-wsCache/ChartDataService"/>
  </wsimport>
  <copy todir="${build.generated.sources.dir}/jax-ws">
  <fileset dir="${build.generated.dir}/jax-wsCache/ChartDataService">
     <include name="**/*.java"/>
   </fileset>
  </copy>
</target>