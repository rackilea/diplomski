StringBuilder builder = new StringBuilder();
String aux = "";

while ((aux = reader.readLine()) != null) {
    builder.append(aux);
}

String text = builder.toString();