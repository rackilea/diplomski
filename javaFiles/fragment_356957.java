# ActionBarSherlock 

-keep class android.support.** { *; } 

-keep interface android.support.** { *; } 

-keep class com.actionbarsherlock.** { *; } 

-keep interface com.actionbarsherlock.** { *; } 




# Keep line numbers to alleviate debugging stack traces 

-renamesourcefileattribute SourceFile 

-keepattributes SourceFile,LineNumberTable