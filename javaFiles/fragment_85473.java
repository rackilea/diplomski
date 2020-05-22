$ frida -Uf com.app.example --no-pause
     ____
    / _  |   Frida 12.1.2 - A world-class dynamic instrumentation toolkit
   | (_| |
    > _  |   Commands:
   /_/ |_|       help      -> Displays the help system
   . . . .       object?   -> Display information about 'object'
   . . . .       exit/quit -> Exit
   . . . .
   . . . .   More info at http://www.frida.re/docs/home/
Spawned `com.app.example`. Resuming main thread!                    
[Android::com.app.example]-> 
function getContext() {
  return Java.use('android.app.ActivityThread').currentApplication().getApplicationContext().getContentResolver();
}                                         
function logAndroidId() {
  console.log('[?]', Java.use('android.provider.Settings$Secure').getString(getContext(), 'android_id'));
}
undefined
[Android::com.app.example]-> Java.perform(logAndroidId)
[?] 52d1497b52bf8a11
undefined
[Android::com.app.example]->