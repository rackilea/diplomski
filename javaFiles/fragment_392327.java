<target name="autoincrementivy" depends="prompt-user.password">
    <exec executable="svn" failonerror="${svn.failonerror}">
        <arg value="--non-interactive"/>
        <arg value="--trust-server-cert"/>
        <arg value="--username"/>
        <arg value="${svn.user}"/>
        <arg value="--password"/>
        <arg value="${svn.password}"/>
        <arg value="checkout"/>
        <arg value="--depth"/>
        **<arg value="immediates"/>**
        <arg value="${svn.repository}/@{module.name}/trunk"/>
         <arg value="${temp.checkout.dir}/@{module.name}"/>
    </exec>
<move file="${temp.checkout.dir}/ivy.xml" tofile="${temp.checkout.dir}/ivy_src.xml"/>
<ant target="changeVersion" antfile="../deploy.xml" >
   <property name="dest.file" value="${temp.checkout.dir}/ivy.xml"/>
  <property name="src.file" value="${temp.checkout.dir}/ivy_src.xml"/>
  <property name="target.version" value="${tag.version}"/>
</ant>
<!-- cehckin the file-->
</target>