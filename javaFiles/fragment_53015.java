class TestAbstract {
    static void execute(String className, String params = "defaults") {
        println "Executing with className = '${className}' and params = '${params}'"
    }
}

def runTest(boolean isUnix) {
    def params = ['MyClassName']

    if (isUnix) {
        params << 'additionalParam'
    }

    TestAbstract.invokeMethod('execute', params as Object[])
}

runTest(true)
runTest(false)