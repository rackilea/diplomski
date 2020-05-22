String str = "DOC_87654321 -ABC76543";
StringBuilder sb = new StringBuilder();

for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    if (Character.isDigit(c)) {
        sb.append(c + " ");
    } else {
        sb.append(c);
    }
}
Log.e("DATA",sb.toString());