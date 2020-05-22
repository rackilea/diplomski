android {
    ...
    testOptions {
        unitTests.all {
            def classpath2 = getClasspath()
            javaexec {
                main = "cucumber.api.cli.Main"
                classpath = classpath2
                args = ['--plugin', 'pretty', '--glue', 'gradle.cucumber', 'src/test/java/cucumber/assets']
            }
        }
    }
)