// build.gradle
plugins {
    id 'org.siouan.frontend' version '1.1.0'
}

frontend {
    nodeVersion = '10.15.3'
    // See 'scripts' section in your 'package.json file'
    cleanScript = 'run clean'
    assembleScript = 'run assemble'
    checkScript = 'run check'
}