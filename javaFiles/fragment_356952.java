apply plugin: "idea"
    sourceSets.main.java.srcDir new File("src", 'main/generated')
    sourceSets.test.java.srcDir new File("src", 'test/generated_tests')
    idea {
        module {
            // Marks the already(!) added srcDir as "generated"
            generatedSourceDirs += file('src/main/generated')
            generatedSourceDirs += file('src/test/generated_tests')
        }
    }