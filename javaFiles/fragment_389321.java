importPackage(java.net);
importPackage(java.io);
var sourceJs = "http://foo.bar.com/js/foo.js";
var url = new URL(sourceJs);

var ucon = url.openConnection();
var istream = ucon.getInputStream();
var isr = new InputStreamReader(istream, "utf-8");
var br = new BufferedReader(isr);
var line = "";
var buf = "";
while((line = br.readLine()) != null) {
     buf = buf + line + "\n";
}
eval(buf);