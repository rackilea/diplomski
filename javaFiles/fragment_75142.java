debugCompile 'com.google.dexmaker:dexmaker-mockito:1.0'
debugCompile 'com.google.dexmaker:dexmaker:1.0'
debugCompile 'org.mockito:mockito-core:1.10.17'

debugCompile ('com.android.support.test.espresso:espresso-core:2.0') {
    exclude group: 'javax.inject'
}
debugCompile 'com.android.support.test:testing-support-lib:0.1'