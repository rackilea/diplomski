evaluationDependsOn 'HelloWorldAgent'

test {
    def jarTask = project('HelloWorldAgent').tasks.jar
    dependsOn jarTask
    afterEvaluate {
        jvmArgs "-javaagent:$jarTask.archivePath"
    }
}