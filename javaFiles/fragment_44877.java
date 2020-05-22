apply plugin: CustomProcessor


import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin

class CustomProcessor implements Plugin<Project> {

    private Project mRoot;
    private List<WrappedProject> mProjects = new ArrayList<>();
    private File mDistribOutput;

    class WrappedProject {
        private final Project project;
        private final Object android;

        WrappedProject(Project project) {
            this.project = project;

            if (isLibrary()) {
                this.android = project.plugins.getPlugin(LibraryPlugin)
                project.logger.info "${project.name}: SDK (API) project detected."
            } else if(isApplication()) {
                project.logger.info "${project.name}: Demo (Sample) project detected."
                this.android = project.plugins.getPlugin(AppPlugin)
            } else {
                project.logger.warn "${project.name}: No Android plugin detected."
                this.android = null
            }
        }

        public boolean isLibrary() {
            return project.plugins.any { p -> p instanceof LibraryPlugin }
        }

        public boolean isApplication() {
            return project.plugins.any { p -> p instanceof AppPlugin }
        }
    }

    @Override
    void apply(Project target) {

        this.mRoot = target
        this.mDistribOutput = new File(target.buildDir, "custom")

        target.configure(target.allprojects) { module ->
            module.afterEvaluate {
                def wrapped = new WrappedProject(module)
                mProjects.add(wrapped)

                if (wrapped.isLibrary()) {
                    addSdkTasks(wrapped.project)
                }

                if (wrapped.isApplication()) {
                    addSampleTasks(wrapped.project)
                }
            }
        }
    }

    void addSdkTasks(Object project) {
        project.android.libraryVariants.all { variant ->
            if (variant.name.equalsIgnoreCase("release")) {
                Task t = project.task("generate${project.name.capitalize()}Javadoc", type: Javadoc, overwrite: true) {
                    description "Generates Javadoc for $project.name."
                    source = variant.javaCompile.source
                    ext.androidJar = "${project.android.sdkDirectory}/platforms/${project.android.compileSdkVersion}/android.jar"
                    classpath = project.files(variant.javaCompile.classpath.files) + project.files(ext.androidJar)
                    exclude '**/BuildConfig.java'
                    exclude '**/R.java'
                    failOnError = false
                }
                t.group = 'custom'

                t = project.task("javadoc${project.name.capitalize()}", type: Jar, overwrite: true) {
                    description "Bundles Javadoc into a JAR file for $project.name."

                    classifier = "javadoc"
                    appendix = project.name
                    baseName = mRoot.name
                    version = project.version

                    from project.tasks["generate${project.name.capitalize()}Javadoc"]

                }
                t.group = 'custom'

                t = project.task("jar${project.name.capitalize()}", type: Jar, overwrite: true) {
                    description "Bundles compiled .class files into a JAR file for $project.name."

                    baseName = mRoot.name
                    appendix = project.name
                    version = project.version

                    dependsOn: [project.tasks.assemble ]
                    from variant.javaCompile.destinationDir
                    exclude '**/R.class', '**/R$*.class', '**/R.html', '**/R.*.html'
                }
                t.group = 'custom'
            }
        }
    }

    void addSampleTasks(Object sample) {
        Task t = sample.task(
                "distribute${sample.name.capitalize()}",
                dependsOn: [sample.tasks.assemble, ":sdk:jarSdk", ":sdk:javadocSdk"],
                overwrite: true,
                type: Zip
         ) {
            baseName = mRoot.name
            appendix = project.name
            version = "v${mRoot.project(':sdk').getVersion()}_${getDate()}"
            classifier = 'src'

            from("${project.buildDir}/outputs/apk/") {
                include '**-debug.apk'
                into "apk"
            }

            from("${mRoot.project(':sdk').buildDir}/docs/javadoc") {
                into "doc"
            }

            from("${mRoot.project(':sdk').buildDir}/libs") {
                into "libs"
            }

            from("${mRoot.project(':sdk').buildDir}/libs") {
                into "sample/app/libs"
            }

            from(sample.zipTree("${sample.rootDir}/sample.zip")) {
                into "/"
            }

            from(sample.projectDir) {
                exclude "build"
                exclude "**.iml"
                exclude "build.gradle"
                into "sample/app"
            }
        }
        t.group = 'custom'
    }

    static def getDate() {
        def date = new Date()
        def formattedDate = date.format('yyyyMMddHHmmss')
        return formattedDate
    }
}

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.2.3'
    }
}

allprojects {
    repositories {
        jcenter()
    }
}