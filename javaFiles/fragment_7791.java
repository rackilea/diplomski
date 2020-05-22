task copyProjectA(type: Copy) {
    from project(":projectA").projectDir.toString() + "/src/main/java"
    into project.projectDir.toString() + "/destination"
}

tasks.compileJava.dependsOn += copyProjectA