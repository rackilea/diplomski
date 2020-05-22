task instrument(type: JavaExec) {
    //your instrumentation task steps here
}
compileJava.doLast {
    tasks.instrument.execute()
}
jar {
    //whatever jar actions you need to do
}