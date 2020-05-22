String[] headerValues = res.headers().values().toArray(new String[res.headers().values().size()]);
String[] headerKeys = res.headers().keySet().toArray(new String[res.headers().keySet().size()]);

for (int i = 0; i < headerValues.length; i++) {
    System.out.println("Key: " + headerKeys[i] + " - value: " + headerValues[i]);
}