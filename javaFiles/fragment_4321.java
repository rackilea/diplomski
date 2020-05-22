out.name("secretKey")
out.beginArray();
for ( final String s : application.getSecretKey() ) {
    out.value(s);
}
out.endArray();