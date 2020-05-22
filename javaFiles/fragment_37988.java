-keep public class com.example.testapp.MainActivity$JavaScriptInterface
-keep public class * implements com.example.testapp.MainActivity$JavaScriptInterface
-keepclassmembers class * implements com.example.testapp.MainActivity$JavaScriptInterface{
     <methods>;
}
-keepattributes *Annotation*