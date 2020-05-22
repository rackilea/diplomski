<target name="mytarget">
  <testng outputDir="${results}" failureProperty="tests.failed" haltOnFailure="false" ...>
    ...
  </testng>
  <echo>Tests complete.  Results available in ${results}</echo>
</target>