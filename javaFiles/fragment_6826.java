package de.pdark.epen.editor;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import de.pdark.epen.exceptions.WikiException;

public class Main
{
    public final static String VERSION = "V0.9 (13.05.2010)"; //$NON-NLS-1$
    private final static Logger log = LoggerFactory.getLogger (Main.class);

    private static final String ORG_ECLIPSE_SWT_WIDGETS_SHELL = "org.eclipse.swt.widgets.Shell"; //$NON-NLS-1$

    /**
    * @param args
    */
    @SuppressWarnings({"nls", "PMD.SystemPrintln"})
    public static void main (String[] args)
    {
        String msg = "Starting ePen "+VERSION;
        System.out.println (msg);
        log.info (msg);

        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory ();
        StatusPrinter.print (lc);

        int rc = 1;
        try
        {
            Main main = new Main ();
            main.run (args);
            rc = 0;
        }
        catch (Throwable t) //NOPMD
        {
            ExceptionUtils.printRootCauseStackTrace (t);
        }
        finally
        {
            System.out.println ("Done.");
            log.info ("Exit {}", rc);
            System.exit (rc); //NOPMD
        }
    }

    @SuppressWarnings({"nls", "PMD.SystemPrintln", "PMD.SignatureDeclareThrowsException"})
    private void run (String[] args) throws Exception
    {
        if (!SystemUtils.isJavaVersionAtLeast (150))
        {
            System.out.println ("Version="+SystemUtils.JAVA_VERSION_INT);
            throw new WikiException ("Need at least Java 5 but this Java is only "+SystemUtils.JAVA_VERSION);
        }

        loadSwtJar ();

        URLClassLoader cl = (URLClassLoader) getClass().getClassLoader(); //NOPMD
        Class<?> c = cl.loadClass ("de.pdark.epen.editor.EPenEditor");
        Class<?> shellClass = cl.loadClass (ORG_ECLIPSE_SWT_WIDGETS_SHELL);

        Constructor<?> ctor = c.getConstructor (shellClass);
        Object obj = ctor.newInstance (new Object[] { null });
        Method run = c.getMethod ("run", args.getClass ()); //$NON-NLS-1$
        run.invoke (obj, new Object[] { args });
    }

    @SuppressWarnings({"nls", "PMD"})
    private void loadSwtJar ()
    {
        try {
            Class.forName (ORG_ECLIPSE_SWT_WIDGETS_SHELL);
            // Already on classpath
            return;
        } catch (ClassNotFoundException e) {
            // Add the JAR
        }

        String osName = SystemUtils.OS_NAME.toLowerCase ();
        String osArch = SystemUtils.OS_ARCH.toLowerCase ();

        String swtFileNameOsPart = 
            osName.contains("win") ? "win32" :
            osName.contains("mac") ? "macosx" :
            osName.contains("linux") || osName.contains("nix") ? "linux" :
            null;
        String swtFileNameUiPart = 
            osName.contains("win") ? "win32" :
            osName.contains("mac") ? "cocoa" :
            osName.contains("linux") || osName.contains("nix") ? "gtk" :
            null;

        if (null == swtFileNameOsPart)
        {
            throw new RuntimeException ("Can't determine name of SWT Jar from os.name=[" + osName + "] and os.arch=["
                    + osArch + "]");
        }

        String swtFileNameArchPart = osArch.contains ("64") ? ".x86_64" : ".x86";
        if(".x86".equals(swtFileNameArchPart) && "macosx".equals(swtFileNameOsPart)) {
            swtFileNameArchPart = "";
        }

        String swtFileName = "org.eclipse.swt." + swtFileNameUiPart + "." + swtFileNameOsPart + swtFileNameArchPart + "-3.6.0.jar";
        File file = new File ("swt", swtFileName);
        if (!file.exists ())
        {
            throw new RuntimeException ("Can't locate SWT Jar " + file.getAbsolutePath ());
        }
        try
        {
            URLClassLoader classLoader = (URLClassLoader) getClass ().getClassLoader ();
            Method addUrlMethod = URLClassLoader.class.getDeclaredMethod ("addURL", URL.class);
            addUrlMethod.setAccessible (true);

            URL swtFileUrl = file.toURI ().toURL ();
            log.info ("Adding {} to the classpath", swtFileUrl);
            addUrlMethod.invoke (classLoader, swtFileUrl);
        }
        catch (Exception e)
        {
            throw new RuntimeException ("Unable to add the swt jar to the class path: " + file.getAbsoluteFile (), e);
        }
    }
}