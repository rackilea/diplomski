project(":ear") {
    apply plugin: "java"
    apply plugin: "ear"

    dependencies {
        deploy project(":ejbs")
        deploy project(":rest")
        earlib project(path:":ejbs", configuration:"compile")
        earlib(project(path:":rest", configuration:"compile")) {
            exclude module: 'ejbs'
        }
    }
}