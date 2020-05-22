Properties prop = new Properties();
InputStream is = null;
String currenDir = System.getProperty("user.dir");
String nombreArchivo = currenDir + File.separator + "ubicacion.PROPERTIES";
try {
is=new FileInputStream(nombreArchivo);
prop.load(is);
} catch(IOException ioe) {}

String pc = prop.getProperty("ServiciosWeb");      
Endpoint endpoint = Endpoint.publish( pc, servicios);
}