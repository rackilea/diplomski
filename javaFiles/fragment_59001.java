apply plugin: 'java'
apply plugin: 'jacoco'

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'org.testng', name: 'testng', version: '6.14.3'
}

test {
    useTestNG() {
        includeGroups('unit')
    }
}

task integrationTest(type: Test, dependsOn: ['test']) {
    useTestNG() {
        includeGroups('integration')
    }
}


def jacoco = project.extensions.getByName("jacoco")
jacoco.toolVersion = "0.8.3"

def jacocoTestReport = project.tasks.getByName('jacocoTestReport')
jacocoTestReport.reports {
    xml.enabled false
    csv.enabled false
}

project.tasks.withType(Test).each { t ->
    t.jacoco {
        destinationFile = project.file("$project.buildDir/jacoco/test.exec")
    }
}

jacocoTestReport.dependsOn "integrationTest"