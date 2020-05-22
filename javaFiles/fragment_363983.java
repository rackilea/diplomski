import java.io.*;

class JarRunner {

    public static void main(String[] args) throws IOException,
                                                  ClassNotFoundException {

        File jarFile = new File("test.jar");
        URLClassLoader cl = new URLClassLoader(new URL[] {jarFile.toURL() });
        JarFile jf = new JarFile(jarFile);

        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            String clsName = je.getName();

            if (!clsName.endsWith(".class"))
                continue;

            int dot = clsName.lastIndexOf('.');
            Class<?> clazz = cl.loadClass(clsName.substring(0, dot));
            try {
                Method m = clazz.getMethod("main", String[].class);
                m.invoke(null, (Object) new String[0]);
            } catch (SecurityException e) {
            } catch (NoSuchMethodException e) {
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
    }
}