C:\java\injar>dir
 El volumen de la unidad C no tiene etiqueta.
 El número de serie del volumen es: 22A8-203B

 Directorio de C:\java\injar

21/02/2011  06:23 p.m.    <DIR>          .
21/02/2011  06:23 p.m.    <DIR>          ..
21/02/2011  06:23 p.m.             1,752 i18n.jar
21/02/2011  06:23 p.m.    <DIR>          src
21/02/2011  06:21 p.m.    <DIR>          x

C:\java\injar>jar -tf i18n.jar
META-INF/
META-INF/MANIFEST.MF
I18n.class
x/
x/y/
x/y/z/
x/y/z/hola.txt

C:\java\injar>type src\I18n.java
import java.util.*;
import java.net.*;
import java.util.jar.*;
class I18n {
    public static void main( String ... args ) {
        getLocaleListFromJar();
    }
    private static List<Locale> getLocaleListFromJar() {
        List<Locale> locales = new ArrayList<Locale>();
        try {
            URL packageUrl = I18n.class.getProtectionDomain().getCodeSource().getLocation();
            JarInputStream jar = new JarInputStream(packageUrl.openStream());
            while (true) {
                JarEntry entry = jar.getNextJarEntry();
                if (entry == null) {
                    System.out.println( "entry was null ");
                    break;
                }
                String name = entry.getName();
                System.out.println( "found : " +name );
                /*if (resourceBundlePattern.matcher(name).matches()) {
                    addLocaleFromResourceBundle(name, locales);
                }*/
           }
        } catch (Exception e) {
            System.err.println(e);
            return null;
            //return getLocaleListFromFile(); // File based implementation in case resources are not in jar
        }
        return locales;
    }
}


C:\java\injar>java -jar i18n.jar
found : I18n.class
found : x/
found : x/y/
found : x/y/z/
found : x/y/z/hola.txt
entry was null