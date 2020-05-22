implementation ("org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version") {
    exclude group: 'org.jetbrains', module: 'annotations'
}

implementation ('com.vimeo.networking:vimeo-networking:1.1.1') {
    exclude group: 'org.jetbrains', module: 'annotations'
}