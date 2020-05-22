Method methodToFind = null;
if (e.getClass().getName().endsWith("FaultMsg")){
    try {
      methodToFind = e.getClass().getMethod("getFaultMsg", (Class<?>[]) null);
    } catch (NoSuchMethodException | SecurityException e) {
      // Your exception handling goes here
    }
}