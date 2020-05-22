-keepattributes Signature,*Annotation*
-dontobfuscate

// turn some optimizations off when using -dontobfuscate
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*,!code/allocation/variable,!class/unboxing/enum

// lots of other classes, e.g. logging
-keep public class ch.qos.logback.** { *;}
-keep public class org.slf4j.** { *;}