configurations {
    jaxb
}

dependencies {
    jaxb group: 'com.sun.xml.bind', name: 'jaxb-xjc', version: '2.2.4-1'
}

task jaxb () {
    // output directory
    jaxbTargetDir = file( "${buildDir}/generated-sources" )
    jaxbTargetDirV19 = file( jaxbTargetDir.path + '/v19' )
    jaxbTargetDirV110 = file( jaxbTargetDir.path + '/v110' )
    jaxbTargetDirOtherWs = file( jaxbTargetDir.path + '/otherWs' )

    // perform actions
    doLast {
        jaxbTargetDirV19.mkdirs()
        jaxbTargetDirV110.mkdirs()
        jaxbTargetDirOtherWs.mkdirs()

        ant.taskdef(name: 'xjc', classname: 'com.sun.tools.xjc.XJCTask', classpath: configurations.jaxb.asPath)
        ant.jaxbTargetDirV19 = jaxbTargetDirV19
        ant.jaxbTargetDirV110 = jaxbTargetDirV110
        ant.jaxbTargetDirOtherWs = jaxbTargetDirOtherWs

        // My-Webservice v1.10
        ant.xjc(
                destdir: '${jaxbTargetDirV110}',
                package: 'mypackage.ws.generated.v110',
                schema: 'src/main/resources/wsdl/v1.10/MyServiceSchema.xsd'
        )

        // My-Webservice v1.9
        ant.xjc(
                destdir: '${jaxbTargetDirV19}',
                package: 'mypackage.ws.generated.v19',
                schema: 'src/main/resources/wsdl/v1.9/MyServiceSchema.xsd'
        )

        // OtherWs-Webservice
        ant.xjc(
                destdir: '${jaxbTargetDirOtherWs}',
                package: 'mypackage.otherws.generated',
                schema: 'src/main/resources/wsdl/OtherWsServiceSchema.xsd'
        )
    }
}
compileJava.dependsOn jaxb