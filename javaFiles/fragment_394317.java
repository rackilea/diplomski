<property>
  <description>List of directories to store localized files in. An 
    application's localized file directory will be found in:
    ${yarn.nodemanager.local-dirs}/usercache/${user}/appcache/application_${appid}.
    Individual containers' work directories, called container_${contid}, will
    be subdirectories of this.
  </description>
  <name>yarn.nodemanager.local-dirs</name>
  <value>${hadoop.tmp.dir}/nm-local-dir</value>
</property>