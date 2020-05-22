<target name='jar.package'>
    <script language='javascript'>
        <![CDATA[
            prop = pscode.getProperty('package');
            index1 = prop.lastIndexOf('pscode') + 7;
            index2 = prop.length();
            prop1 = prop;
            path = prop1.substring( index1, index2 );
            path2 = path.replaceAll('\\\\','/');
            pscode.setProperty('path', path2 );

            name = path2.replaceAll('/','.');
            pscode.setProperty('jar.name', name + '.jar' );
        ]]>
    </script>

    <xmlproperty file="${src}/java/org/pscode/${path}/manifest.xml" />
    <!-- echo message='jar.name: ${jar.name} *** ${application.title}' / -->
    <if>
        <not>
            <uptodate targetfile='${build}/dist/lib/${jar.name}' >
                <srcfiles dir= '${build}/share/org/pscode/${path}' includes='*.class'/>
            </uptodate>
        </not>
        <then>
            <jar
                destfile='${build}/dist/lib/${jar.name}'
                index='true'
                update='true'>
                <manifest>
                        <attribute name="Implementation-Title" value="${application.title}" />
                        <attribute name="Implementation-Vendor" value="${vendor}" />
                        <attribute name="Implementation-Vendor-Id" value="org.pscode" />
                        <attribute name='Implementation-Version' value='${now}' />
                </manifest>
                <fileset dir='${build}/share'>
                    <include name='org/pscode/${path}/*.class' />
                </fileset>
                <fileset dir='${src}/java'>
                    <include name='org/pscode/${path}/*.png' />
                    <include name='org/pscode/${path}/*.jpg' />
                    <include name='org/pscode/${path}/*.gif' />
                    <include name='org/pscode/${path}/*.xml' />
                    <include name='org/pscode/${path}/*.html' />
                    <include name='org/pscode/${path}/*.ser' />
                </fileset>
            </jar>
        </then>
    </if>

    <!-- If the Jar is updated, any previous signatures will be invalid, it
    needs to be signed again. We cannot use the issigned condition since
    that merely checks if a Jar is signed, not if the digital signatures are
    valid. -->
    <exec
        executable='${jar.signer}'
        resultproperty='jar.signer.result.property'
        outputproperty='jar.signer.output.property'>
        <arg value='-verify' />
        <arg value='${build}/dist/lib/${jar.name}' />
    </exec>

    <if>
        <or>
            <not>
                <equals arg1='${jar.signer.result.property}' arg2='0' />
            </not>
            <or>
                <contains
                    string='${jar.signer.output.property}'
                    substring='unsigned'
                    casesensitive='false' />
                <or>
                    <contains
                        string='${jar.signer.output.property}'
                        substring='SecurityException'
                        casesensitive='false' />
                </or>
            </or>
        </or>
        <then>
            <signjar
                jar='${build}/dist/lib/${jar.name}'
                alias='pscode'
                storepass='${sign.password}'
                force='true'
                verbose='${verbose}'
                keystore='${user.home}/${sign.pathfilename}' />
        </then>
    </if>

</target>