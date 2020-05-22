@Override
void apply(Project project) {
    project.afterEvaluate {
        project.afterEvaluate {

            project.dependencies {
                compile 'com.github.wrdlbrnft:proguard-annotations-api:0.2.0.44'
                apt 'com.github.wrdlbrnft:proguard-annotations-processor:0.2.0.44'
            }
        }
    }
}