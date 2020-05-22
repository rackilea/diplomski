from("${project(':common').buildDir}/classes/main") {
    include('com/classpath/ClassA.class')
    include('com/classpath/ClassB.class')
    include('com/classpath/ClassC.class')
    include('com/classpath/ClassD.class')
    include('com/classpath/ClassE.class')
}