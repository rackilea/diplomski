import netscape.javascript.JSObject;

String data = "";
String cookiename = "fooCookie";
JSObject myBrowser = JSObject.getWindow(this);
JSObject myDocument = (JSObject) myBrowser.getMember("document");

String myCookie = (String) myDocument.getMember("cookie");
if (myCookie.length() > 0) {
    String[] cookies = myCookie.split(";");
    for (String cookie : cookies) {
        int pos = cookie.indexOf("=");
        if (cookie.substring(0, pos).trim().equals(cookiename)) {
            data = cookie.substring(pos + 1);
            break;
        }
    }
}