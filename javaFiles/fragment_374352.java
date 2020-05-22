import java.util.jar.*;

...

JarFile myJar = new JarFile("nameOfJar.jar");    // various constructors available
Manifest manifest = myJar.getManifest();
Map<String,Attributes> manifestContents = manifest.getAttributes();