// global variables
ext {
    // can be set to default values or blank
    groupFreePro = "free"
}

// start parameters
println "Start parametes: tasks = " + gradle.startParameter.getTaskNames()

gradle.startParameter.getTaskNames().each { task ->
    if (task.contains("Free") || task.contains("F")) {
        groupFreePro = "free"
    } else if (task.contains("Pro") || task.contains("P")) {
        groupFreePro = "pro"
    }
    println "groupFreePro = " + groupFreePro
}

android {
...
}