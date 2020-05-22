apply plugin: 'com.android.library'

android {
    defaultConfig {
        ...
        manifestPlaceholders = [my_app_id: "\${my_app_id}"] // <- important backslash!!!
    }
}