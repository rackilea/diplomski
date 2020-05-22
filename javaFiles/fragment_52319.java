private static final isDebugMode = true;

...

if (!isDebugMode) {
  System.setErr(logWriter);
  System.setOut(logWriter);
}