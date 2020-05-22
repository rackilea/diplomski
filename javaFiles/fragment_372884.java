test {
    java {
        srcDir 'test'
    }
    resources {
        srcDir 'test'
        include '**/*.xml','**/*.csv'
    }
}