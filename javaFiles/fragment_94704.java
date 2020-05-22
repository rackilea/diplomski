buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath 'org.aspectj:aspectjtools:1.8.10'
    }
}
dependencies {
    compile 'org.aspectj:aspectjrt:1.8.1'
    compile 'net.sf.oval:oval:1.86'
}

tasks.withType(JavaCompile) {
    doLast {
        String[] args = ["-showWeaveInfo",
                         "-1.8",
                         "-inpath", destinationDir.toString(),
                         "-aspectpath", classpath.asPath,
                         "-d", destinationDir.toString(),
                         "-classpath", classpath.asPath]

        MessageHandler handler = new MessageHandler(true);
        new Main().run(args, handler)
    }