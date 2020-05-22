// Maybe you have to correct this or use another / no Locale
DateFormat format = new SimpleDateFormat("EE MMM dd HH:mm:ss z YYYY", Locale.US);


RegistryMatcher m = new RegistryMatcher();
m.bind(Date.class, new DateFormatTransformer(format));


Serializer ser = new Persister(m);
Example e = ser.read(Example.class, xml);