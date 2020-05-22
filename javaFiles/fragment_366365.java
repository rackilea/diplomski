androidTestImplementation("com.android.support.test.espresso:espresso-contrib:2.2.2") {
    exclude group: 'com.android.support', module: 'appcompat'
    exclude group: 'com.android.support', module: 'support-v4'
    exclude group: 'com.android.support', module: 'support-v7'
    exclude group: 'com.android.support', module: 'design'
    exclude module: 'support-annotations'
    exclude module: 'recyclerview-v7'
}