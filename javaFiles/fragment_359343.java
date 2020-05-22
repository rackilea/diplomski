<ivysettings>
  <include url="${ivy.default.settings.dir}/ivysettings.xml"/>
  <property name="ivy.local.default.ivy.pattern"      value="[organisation]/[module]/[revision]/[type]s/[artifact]-[revision].[ext]" override="true"/>
  <property name="ivy.local.default.artifact.pattern" value="[organisation]/[module]/[revision]/[type]s/[artifact]-[revision].[ext]" override="true"/>
  <resolvers>
    <filesystem name="local">
      <ivy pattern="${ivy.local.default.root}/${ivy.local.default.ivy.pattern}" />
      <artifact pattern="${ivy.local.default.root}/${ivy.local.default.artifact.pattern}" />
    </filesystem>
  </resolvers>
</ivysettings>