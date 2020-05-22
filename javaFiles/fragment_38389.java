<project>
  <script language="javascript"><![CDATA[
    importClass(java.lang.Runtime)
    project.setProperty("memoryMaximumSize", Runtime.getRuntime().maxMemory());
  ]]></script>
  <javac srcdir="." memoryMaximumSize="${memoryMaximumSize}" fork="true"/>
</project>