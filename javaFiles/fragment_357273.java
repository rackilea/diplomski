// ----- 

class MyPackageTask extends DefaultTask {
    def init() { println 'common stuff' }
    @TaskAction
    def doPackage() {
        println 'hello from MyPackageTask'
    }
}

class AmazonPackageTask extends MyPackageTask {
    @TaskAction
    def doPackage() {
        init()
        println 'hello from AmazonPackageTask'
    }
}

class GooglePackageTask extends MyPackageTask {
    @TaskAction
    def doPackage() {
        init()
        println 'hello from GooglePackageTask'
    }
}