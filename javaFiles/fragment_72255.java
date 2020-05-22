import netscape.javascript.*;
import java.applet.*;
import java.awt.*;
class MyApplet extends Applet {
     public void init() {
         JSObject win = JSObject.getWindow(this);
         JSObject doc = (JSObject) win.getMember("document");
         JSObject loc = (JSObject) doc.getMember("location");

         String s = (String) loc.getMember("href");  // document.location.href
         win.call("f", null);                      // Call f() in HTML page
     }
}