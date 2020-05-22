public static String ip (String url){
String resulta = "";
try {
    String webPagea = url;
    URL urla = new URL(webPagea);
    URLConnection urlConnectiona = urla.openConnection();
    InputStream isa = urlConnectiona.getInputStream();
    InputStreamReader isra = new InputStreamReader(isa);

    int numCharsReada;
    char[] charArraya = new char[1024];
    StringBuffer sba = new StringBuffer();
    while ((numCharsReada = isra.read(charArraya)) > 0) {
        sba.append(charArraya, 0, numCharsReada);
    }
    resulta = sba.toString();
} catch (Exception e) {

}
    return resulta;
}