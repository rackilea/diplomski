compile('org.springframework.android:spring-android-rest-template:2.0.0.M3') {
    exclude module: 'spring-android-core'
}

compile('org.springframework.security.oauth:spring-security-oauth2:2.3.0.RC1'){
    exclude module: 'spring-web'
}