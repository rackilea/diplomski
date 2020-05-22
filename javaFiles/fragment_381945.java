String data = "test";
String cookiename = "fooCookie";
JSObject win = JSObject.getWindow(this);
JSObject doc = (JSObject) win.getMember("document");
String data = cookiename + "=" + data + "; path=/; expires=Thu, 31-Dec-2019 12:00:00 GMT";
doc.setMember("cookie", data);