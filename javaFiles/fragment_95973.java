<pathconvert targetos="unix" property="fulltrainer.unix_dir">
    <path location="${trainer.dir}"/>
</pathconvert>

<property name="cf.props" value="${trainer.dir}/properties/commonConfig.properties"/>
<echo file="${cf.props}" message="# KEY         VALUE"/>
<echo file="${cf.props}" append="yes" message="CurrentBuildFile=${fulltrainer.unix_dir}/current_build"/>