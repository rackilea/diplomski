String str = "http://maps.google.com/maps/api/geocode/xml?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=true";
URL url = new URL(str);
InputStream is = url.openStream();
int ptr = 0;
StringBuilder builder = new StringBuilder();
while ((ptr = is.read()) != -1) {
    builder.append((char) ptr);
}
String xml = builder.toString();