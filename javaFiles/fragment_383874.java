<server>
  <!-- Load all jars from the JBOSS_HOME/server/<config>/lib directory and
       the shared JBOSS_HOME/common/lib directory. This can be restricted to
       specific jars by specifying them in the archives attribute.
       TODO: Move this configuration elsewhere
  -->
  <classpath codebase="${jboss.server.lib.url}" archives="*"/>
  <classpath codebase="${jboss.common.lib.url}" archives="*"/>
</server>