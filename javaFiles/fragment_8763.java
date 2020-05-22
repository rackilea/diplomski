configurations.all {
    exclude group: 'com.android.support', module: 'support-v4'
}

dependencies {
    compile files('libs/support-v4.jar')
}