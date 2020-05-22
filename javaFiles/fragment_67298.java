public static String reEncode( String input ) {
    Charset w1252 = Charset.forName("Windows-1252"); //Superset of ISO-8859-1
    Charset utf8 = Charset.forName("UTF-8");
    return new String(input.getBytes(w1252), utf8 );
}

...

String fileName = reEncode("MekanizmasÄ±.pdf"); //request.getHeader("X-File-Name")
System.out.println(fileName); //Mekanizması.pdf