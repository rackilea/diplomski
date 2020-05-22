public static void main(String[] args) {

    String str = "'id': 1268, 'name': 'Reserva de Usos M\\xfaltiples de " +
                 "la Cuenca del Lago de Atitl\\xe1n-RUMCLA (Atitl\\xe1n " +
                 "Watershed Multiple Use Reserve)'";

    Matcher matcher = Pattern.compile("\\\\x([0-9a-f]{2})").matcher(str);

    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        int codepoint = Integer.valueOf(matcher.group(1), 16);
        matcher.appendReplacement(sb, String.valueOf((char) codepoint));
    }
    matcher.appendTail(sb);

    System.out.println(sb);
}