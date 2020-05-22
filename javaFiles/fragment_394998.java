// part of build.gradle of the sub-project
...
dependencies {
    compile group: 'org.apache.hbase', name: 'hbase-client', version: '1.2.4'
}

shadowJar {
    relocate('com.google.protobuf', 'hbasesaver.google.protobuf')
}

// part of build.gradle for main project
...
compile project(path: ':hbase-wrapper', configuration: 'shadow')