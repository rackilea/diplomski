//This script
...
if (requested.group == 'com.android.support') {
    if (!requested.name.startsWith("multidex")) {
        details.useVersion '25.3.0'
    }
}