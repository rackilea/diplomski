configurations {
  libOneReleaseCompile
  libTwoReleaseCompile
}

dependencies {
    compile 'com.android.support:support-v4:23.1.1'
    compile 'com.android.support:support-annotations:23.1.1'
    compile 'com.android.support:appcompat-v7:23.1.1'

    libOneReleaseCompile 'lib.one.speech'
    libTwoReleaseCompile 'lib.two.speech'
}