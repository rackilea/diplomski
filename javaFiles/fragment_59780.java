diff --git a/src/main/java/com/vinaysshenoy/types/Types.java b/src/main/java/com/vinaysshenoy/types/Types.java
index e3a44d8..92ac237 100644
--- a/src/main/java/com/vinaysshenoy/types/Types.java
+++ b/src/main/java/com/vinaysshenoy/types/Types.java
@@ -17,9 +17,9 @@ package com.vinaysshenoy.types;


 import static com.vinaysshenoy.types.util.Util.EMPTY_TYPE_ARRAY;
-import static com.vinaysshenoy.types.util.Util.GenericArrayTypeImpl;
-import static com.vinaysshenoy.types.util.Util.ParameterizedTypeImpl;
-import static com.vinaysshenoy.types.util.Util.WildcardTypeImpl;
+import com.vinaysshenoy.types.util.Util.GenericArrayTypeImpl;
+import com.vinaysshenoy.types.util.Util.ParameterizedTypeImpl;
+import com.vinaysshenoy.types.util.Util.WildcardTypeImpl;
 import static com.vinaysshenoy.types.util.Util.getGenericSupertype;
 import static com.vinaysshenoy.types.util.Util.resolve;