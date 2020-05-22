ext {
    googlePlayVer = "10.2.0"
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.0.0'
    compile 'com.android.support.constraint:constraint-layout:1.0.2'

    // For example
    compile "com.google.firebase:firebase-core:${googlePlayVer}"
    compile "com.google.firebase:firebase-auth:${googlePlayVer}"
    compile "com.google.firebase:firebase-database:${googlePlayVer}"