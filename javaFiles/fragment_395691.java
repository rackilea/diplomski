task runBenchmark(type: JavaExec, dependsOn: test) {
    def vmVer = System.getProperty('java.version')
    def osName = System.getProperty('os.name').replaceAll('\\s','')
    def osArch = System.getProperty('os.arch')
    def fnameBase = "ver${version}_${osName}-${osArch}_jvm${vmVer}"
    def benchMarksDir = "${project.buildDir}/benchmarks"
    ant.mkdir(dir: benchMarksDir)
    def outStream = new FileOutputStream("${benchMarksDir}/${fnameBase}-out.txt")
    standardOutput = outStream
    main = 'org.funcito.benchmarks.MyBenchmark'
    classpath = sourceSets.test.runtimeClasspath
    args = ['--saveResults', "${benchMarksDir}/${fnameBase}.json", '-Jmode=-server,-client']
}