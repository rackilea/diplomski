Path path = Paths.get("myfile.txt");
TikaConfig tika = new TikaConfig();
Metadata metadata = new Metadata();
metadata.set(Metadata.RESOURCE_NAME_KEY, path.toString());
String mimetype = tika.getDetector().detect(TikaInputStream.get(path), metadata).toString();
System.out.println("File " + path + " is " + mimetype);