Closure basicTestConfiguration = {
jvmArgs "-Dactivemq.directory=${testActivemqDir}",
        "-Duser.timezone=Etc/UTC",
        "-javaagent:${configurations.testAgent.singleFile}",
        "-XX:MaxPermSize=256m",
        "-noverify"
...
}