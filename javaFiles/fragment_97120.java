@Override
void apply(Project project) {
    project.afterEvaluate {
        project.afterEvaluate {

            project.dependencies {
                compile 'com.github.wrdlbrnft:proguard-annotations-api:0.2.0.44'
                apt 'com.github.wrdlbrnft:proguard-annotations-processor:0.2.0.44'
            }

            def variants = determineVariants(project)

            project.android[variants].all { variant ->
                configureVariant(project, variant)
            }
        }
    }
}

private static String determineVariants(Project project) {
    if (project.plugins.findPlugin('com.android.application')) {
        return 'applicationVariants';
    } else if (project.plugins.findPlugin('com.android.library')) {
        return 'libraryVariants';
    } else {
        throw new ProjectConfigurationException('The com.android.application or com.android.library plugin must be applied to the project', null)
    }
}