09-20 11:16:16.883 8776-8776/? I/TEST: using Script engine name: JavaScript
09-20 11:16:16.883 8776-8776/test.app E/AndroidRuntime: FATAL EXCEPTION: main
  Process: test.app, PID: 8776
  java.lang.RuntimeException: Unable to start activity ComponentInfo{test.app/test.app.Test}: java.lang.UnsupportedOperationException: Engine not found: JavaScript
      [...]
   Caused by: java.lang.UnsupportedOperationException: Engine not found: JavaScript
      at test.app.Test.execute(Test.java:37)
      at test.app.Test.scriptMethod(Test.java:23)
      at test.app.Test.onCreate(Test.java:17)
      [...]