import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;

import org.apache.openejb.loader.IO;
import org.apache.tomee.embedded.EmbeddedTomEEContainer;


public class Main {

    public static void main(String[] args) {
    EJBContainer container = null;
    try {
        System.out.println("Start");
        final File war = createWar();
            final Properties p = new Properties();
            p.setProperty(EJBContainer.APP_NAME, "test");
            p.setProperty(EJBContainer.PROVIDER, EmbeddedTomEEContainer.class.getName());
            p.put(EJBContainer.MODULES, war.getAbsolutePath());
            p.setProperty(EmbeddedTomEEContainer.TOMEE_EJBCONTAINER_HTTP_PORT, "-1");

            System.out.println(war.getAbsolutePath());

            container = EJBContainer.createEJBContainer(p);
            System.out.println(container);
            System.out.println(container.getContext());
            final URL url = new URL("http://127.0.0.1:" + System.getProperty(EmbeddedTomEEContainer.TOMEE_EJBCONTAINER_HTTP_PORT) + "/test/index.html");
            System.out.println(getOk(url, 2));

        } catch (Throwable e) {
            System.err.println(e.getLocalizedMessage());
        e.printStackTrace();
    } finally {

            if (container != null) {
                container.close();
            }
        }
    }
    private static String getOk(final URL url, final int tries) throws Exception {
        try {
            return IO.readProperties(url).getProperty("ok");
        } catch (final IOException e) {
            if (tries > 0) {
                Thread.sleep(1000);
                return getOk(url, tries - 1);
            } else {
                throw e;
            }
        }
    }

    private static File createWar() throws IOException {
        final File file = new File(System.getProperty("java.io.tmpdir") + "/tomee-" + Math.random());
        if (!file.mkdirs() && !file.exists()) {
            throw new RuntimeException("can't create " + file.getAbsolutePath());
        }

        write("ok=true", new File(file, "index.html"));
        write("<beans />", new File(file, "WEB-INF/classes/META-INF/beans.xml"));
        return file;
    }

    private static void write(final String content, final File file) throws IOException {
        if (!file.getParentFile().mkdirs() && !file.getParentFile().exists()) {
            throw new RuntimeException("can't create " + file.getParent());
        }

        final FileWriter index = new FileWriter(file);
        index.write(content);
        index.close();
    }
}