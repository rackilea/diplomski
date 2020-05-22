plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.5'
}

repositories {
    mavenCentral()
}

dependencies {
    compile ('org.transentials:cardhouse-commons:1.1.1') {
        exclude group: 'org.openjfx'
    }
    compile files('libs/cardhouse-commons-master-1.1.1.jar')
    ...
    compile 'javax.validation:validation-api:2.0.1.Final'
}

javafx {
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}

mainClassName = 'open.terms.client.jfx.Main'