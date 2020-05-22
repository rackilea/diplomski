-keepclassmembers class fqcn.of.javascript.interface.for.webview {
public *;
}

# added to prevent runtime errors (kazsato)
-keep class * extends java.util.ListResourceBundle {
protected Object[][] getContents();
}

-dontwarn javax.jdo.**