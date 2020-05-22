public class ScriptManager {

      private Class currentScript;
      private Object scriptInstance;
      private int state;

      public ScriptManager() {
        try {
            scriptInstance = currentScript.newInstance();
            currentScript.getMethod("run").invoke(scriptInstance);
            //the rest
        } catch (Exception e) {
            e.printStackTrace();
        }
      }

      public void pauseScript() {
        try {
            currentScript.getMethod("pause").invoke(scriptInstance);
            //the rest
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
//the rest
}