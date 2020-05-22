diff --git a/app/build.gradle b/app/build.gradle
index 8f606bb..2fb997b 100644
--- a/app/build.gradle
+++ b/app/build.gradle
@@ -62,7 +62,8 @@ dependencies {
     compile 'javax.annotation:javax.annotation-api:1.2'
     compile 'io.grpc:grpc-stub:1.3.0'
     compile 'io.grpc:grpc-okhttp:1.3.0'
+    compile 'io.grpc:grpc-protobuf-lite:1.3.0'

-    compile 'com.google.api.grpc:googleapis-common-protos:0.0.3'
+    protobuf 'com.google.api.grpc:googleapis-common-protos:0.0.3'
     protobuf 'com.google.protobuf:protobuf-java:3.1.0'
 }