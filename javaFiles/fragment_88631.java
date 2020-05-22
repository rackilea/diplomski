buildscript {
    configurations {
        classpath {
            exclude group: 'org', module: 'foo' // For a global exclude
        }
    }
    dependencies {
        classpath('org:bar:1.0') {
            exclude group: 'org', module: 'baz' // For excluding baz from bar but not if brought elsewhere
        }
    }
}