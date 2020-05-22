diff --git a/src/main/java/com/spring/aspect/dynamicflow/Application.java b/src/main/java/com/spring/aspect/dynamicflow/Application.java
index 2a7021e..3a7636f 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/Application.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/Application.java
@@ -8,6 +8,16 @@ import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.context.ConfigurableApplicationContext;

+/**
+ * Run this from your IDE with
+ *
+ * a) either just -javaagent:/path/to/aspectjweaver.jar and without @EnableLoadTimeWeaving
+ *
+ * b) or with both -javaagent:/path/to/aspectjweaver.jar -javaagent:/path/to/spring-instrument.jar,
+ * either with or without @EnableLoadTimeWeaving. What benefit this has, I don't know.
+ *
+ * See also my extensive comment in Application class.
+ */
 @SpringBootApplication
 public class Application {
   private static final Logger log = LoggerFactory.getLogger(Application.class);
diff --git a/src/main/java/com/spring/aspect/dynamicflow/ApplicationConfig.java b/src/main/java/com/spring/aspect/dynamicflow/ApplicationConfig.java
index b4698e1..649a6ca 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/ApplicationConfig.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/ApplicationConfig.java
@@ -3,8 +3,34 @@ package com.spring.aspect.dynamicflow;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.EnableAspectJAutoProxy;
+import org.springframework.context.annotation.EnableLoadTimeWeaving;

+import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.ENABLED;
+
+/**
+ * Remarks about AspectJ load-time weaving(LTW) in Spring:
+ *
+ * According to the Spring manual it should be enough to put spring-instrument.jar is on the JVM command line
+ * in combination with @EnableLoadTimeWeaving. Actually this does help Spring detect the AspectJ weaver,
+ * I can see the aspects loaded. But obviously this happens too late after the application classes are
+ * already loaded, so the aspects do not have any effect. I even added a static block
+ * static { logger.info("JobProcessImpl class was loaded"); } to JobProcessImpl in order to check it an
+ * the log output occurs right before the aspects are being activated, which of course is too late.
+ *
+ * LTW works if
+ *
+ * a) either I have both Java agents aspectjweaver.jar and spring-instrument.jar on JVM command line
+ * in combination with @EnableLoadTimeWeaving (but then it tries to weave twice, I can see errors in the log)
+ * or without @EnableLoadTimeWeaving (no errors in the log)
+ *
+ * b) or if I only use aspectjweaver.jar without @EnableLoadTimeWeaving.
+ *
+ * The latter is no surprise because AspectJ is independent of Spring and of course works even if Spring is
+ * unaware of its presence. But if I want to advertise its presence via @EnableLoadTimeWeaving, I do not
+ * understand why spring-instrument.jar is not enough, as described in the Spring manual.
+ */
 @Configuration
 @EnableAspectJAutoProxy
 @ComponentScan("com.spring.aspect.dynamicflow")
+//@EnableLoadTimeWeaving(aspectjWeaving = ENABLED)
 public class ApplicationConfig {}
diff --git a/src/main/java/com/spring/aspect/dynamicflow/activity/AnnotationTask.java b/src/main/java/com/spring/aspect/dynamicflow/activity/AnnotationTask.java
index 3c6d5c4..bbdd5b1 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/activity/AnnotationTask.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/activity/AnnotationTask.java
@@ -6,9 +6,7 @@ import org.aspectj.lang.ProceedingJoinPoint;
 import org.aspectj.lang.annotation.Aspect;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
-import org.springframework.stereotype.Component;

-@Component
 @Aspect
 public class AnnotationTask extends Task {
   private static final Logger log = LoggerFactory.getLogger(AnnotationTask.class);
diff --git a/src/main/java/com/spring/aspect/dynamicflow/activity/ReviewTask.java b/src/main/java/com/spring/aspect/dynamicflow/activity/ReviewTask.java
index ece0ff6..f364da2 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/activity/ReviewTask.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/activity/ReviewTask.java
@@ -6,9 +6,7 @@ import org.aspectj.lang.ProceedingJoinPoint;
 import org.aspectj.lang.annotation.Aspect;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
-import org.springframework.stereotype.Component;

-@Component
 @Aspect
 public class ReviewTask extends Task {
   private static final Logger log = LoggerFactory.getLogger(ReviewTask.class);
diff --git a/src/main/java/com/spring/aspect/dynamicflow/activity/Task.java b/src/main/java/com/spring/aspect/dynamicflow/activity/Task.java
index 3f1f9ce..93b3b73 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/activity/Task.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/activity/Task.java
@@ -6,9 +6,7 @@ import org.aspectj.lang.annotation.Around;
 import org.aspectj.lang.annotation.Aspect;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
-import org.springframework.stereotype.Component;

-@Component
 @Aspect
 public abstract class Task {
   private static final Logger log = LoggerFactory.getLogger(Task.class);
diff --git a/src/main/java/com/spring/aspect/dynamicflow/aspect/TaskAspects.java b/src/main/java/com/spring/aspect/dynamicflow/aspect/TaskAspects.java
index 3bff7b5..a09d9d6 100644
--- a/src/main/java/com/spring/aspect/dynamicflow/aspect/TaskAspects.java
+++ b/src/main/java/com/spring/aspect/dynamicflow/aspect/TaskAspects.java
@@ -5,9 +5,7 @@ import org.aspectj.lang.annotation.Around;
 import org.aspectj.lang.annotation.Aspect;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
-import org.springframework.stereotype.Component;

-@Component
 @Aspect
 public class TaskAspects {
   private static final Logger log = LoggerFactory.getLogger(TaskAspects.class);
diff --git a/src/main/resources/org/aspectj/aop.xml b/src/main/resources/org/aspectj/aop.xml
new file mode 100644
index 0000000..56342b4
--- /dev/null
+++ b/src/main/resources/org/aspectj/aop.xml
@@ -0,0 +1,15 @@
+<!DOCTYPE aspectj PUBLIC "-//AspectJ//DTD//EN" "http://www.eclipse.org/aspectj/dtd/aspectj.dtd">
+<aspectj>
+
+  <weaver options="-verbose -showWeaveInfo">
+    <!-- only weave classes in our application-specific packages -->
+    <include within="com.spring.aspect.dynamicflow..*"/>
+  </weaver>
+
+  <aspects>
+    <aspect name="com.spring.aspect.dynamicflow.aspect.TaskAspects"/>
+    <aspect name="com.spring.aspect.dynamicflow.activity.AnnotationTask"/>
+    <aspect name="com.spring.aspect.dynamicflow.activity.ReviewTask"/>
+  </aspects>
+
+</aspectj>