-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose

-keep, allowobfuscation class com.company.*
-keepclassmembers, allowobfuscation class * {
    *;
}

-keepnames class com.company.MyClass
-keepclassmembernames class com.company.MyClass {
    public <methods>;
    public <fields>;
    #!private *; also tried this but it didn't work
}