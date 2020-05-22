apply plugin: 'java'

task taskA <<{
    println 'task A'
}

task taskB (type:Copy){
    println 'B'
}

task taskC (type:Copy){
    println 'C'
}
task taskBC (dependsOn:['taskB','taskC'])<<{
    println 'BC'
}
taskBC.mustRunAfter taskA