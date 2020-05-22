<target description="bundle sources in a jar" name="package-sources">
  <jar basedir="src" destfile="dist/${ant.project.name}-sources.jar"/>
</target>
<target depends="-javadoc-build" description="bundle javadoc in a jar" name="package-doc">
  <jar basedir="dist/javadoc" destfile="dist/${ant.project.name}-javadoc.jar"/>
</target>