final File testFile = new File("test.xml");

Settings settings = new Settings();
settings.put("a", "b");
settings.put("c", 3);
settings.put("d", new Date());

// Serialize - make shure you use an AnnotationStrategy here
Serializer ser = new Persister(new AnnotationStrategy());
ser.write(settings, testFile); 


// Deserialize
Settings in = ser.read(Settings.class, testFile);

System.out.println(settings.equals(in));