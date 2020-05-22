package a;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class ReloadTest {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        final Class<?> clazz = ReloadTest.class;

        System.out.println("Class: " +  clazz.hashCode());

        final URL[] urls = new URL[1];

        urls[0] =  clazz.getProtectionDomain().getCodeSource().getLocation();
        final ClassLoader delegateParent = clazz.getClassLoader().getParent();

        try (final URLClassLoader cl = new URLClassLoader(urls, delegateParent)) {

            final Class<?> reloadedClazz = cl.loadClass(clazz.getName());
            System.out.println("Class reloaded: " + reloadedClazz.hashCode());
            System.out.println("Are the same: " + (clazz != reloadedClazz) );
        }
    }
}