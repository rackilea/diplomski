import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Constructor;

public class UseURLClassLoader {

 public static void main(String[] args) throws Exception {
  URL[] classLoaderUrls;
  URLClassLoader urlClassLoader;
  Class<?> beanClass;

  classLoaderUrls = new URL[]{new URL("file:/home/axel/Dokumente/JAVA/poi/poi-3.10.1/ooxml-lib/xmlbeans-2.6.0.jar")};
  urlClassLoader = new URLClassLoader(classLoaderUrls); //default delegation parent ClassLoader is used
  beanClass = urlClassLoader.loadClass("org.apache.xmlbeans.XmlOptions");
System.out.println(beanClass.getResource("/org/apache/xmlbeans/XmlOptions.class")); //class is loaded using default parent class loader

  URL context = new URL("file:/home/axel/Dokumente/JAVA/poi/poi-3.10.1/");
  classLoaderUrls = new URL[] {
   new URL(context, "poi-3.10.1-20140818.jar"),
   new URL(context, "poi-ooxml-3.10.1-20140818.jar"),
   new URL(context, "poi-ooxml-schemas-3.10.1-20140818.jar"),
   // maybe others also necessary
   new URL(context, "lib/commons-codec-1.5.jar"),
   // maybe others also necessary
   new URL(context, "ooxml-lib/xmlbeans-2.6.0.jar")
   // maybe others also necessary
  };
  for (int i = 0; i < classLoaderUrls.length; i++) {
System.out.println(classLoaderUrls[i]);
  }
  urlClassLoader = new URLClassLoader(classLoaderUrls, null); //set default parent class loader null
  beanClass = urlClassLoader.loadClass("org.apache.xmlbeans.XmlOptions");
System.out.println(beanClass.getResource("/org/apache/xmlbeans/XmlOptions.class")); //class is loaded using this class loader

 }

}