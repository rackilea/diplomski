class MyObject {
    def scriptDir

    def rate(item) {
        def commonFunctionsScriptFile = new File(scriptDir, "CommonFunctions.groovy")
        def binding = new Binding()
        new GroovyShell(binding).evaluate(commonFunctionsScriptFile)
        println binding.variables.whoami()
    }
}

scriptFile = new File(getClass().protectionDomain.codeSource.location.path)
new MyObject(scriptDir: scriptFile.parentFile).rate(null)