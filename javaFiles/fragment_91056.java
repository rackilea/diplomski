import jdk.nashorn.api.scripting.NashornException;

...

catch (ScriptException e) {
     if (e.getCause() instance of NashornException) 
         String jsStackTrace = NashornException.getScriptStackString(e.getCause());
}