allprojects {
    tasks.whenTaskAdded { theTask ->
        if (theTask.name.equals('assemble')) {
            theTask.dependsOn clean
        }
    }
}