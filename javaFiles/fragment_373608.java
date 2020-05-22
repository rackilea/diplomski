package net.earcam.example.servicecomponent.test;

import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.OptionUtils.combine;
import static org.ops4j.pax.exam.spi.container.PaxExamRuntime.createContainer;
import static org.ops4j.pax.exam.spi.container.PaxExamRuntime.createTestSystem;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.earcam.example.servicecomponent.EchoService;
import net.earcam.example.servicecomponent.SequenceService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.spi.reactors.EagerSingleStagedReactorFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;


@ExamReactorStrategy(EagerSingleStagedReactorFactory.class)
@RunWith(JUnit4TestRunner.class)
public class EchoServiceIntegrationTest {


    public static void main(String[] args) {
        try {
            createContainer(
                    createTestSystem(
                            combine(
                                    new EchoServiceIntegrationTest().config(), 
                                    profile("gogo"))
                    )).start();
        } catch(Throwable t) {
            t.printStackTrace();
        }
    }



    @Configuration
    public Option[] config()
    {
        return options(
                felix(),
                equinox(),
                junitBundles(),
                systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("TRACE"),
                mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.scr").versionAsInProject(),
                bundle("file:" + findFileInCurrentDirectoryAndBelow(
                        Pattern.compile("net\\.earcam\\.example\\.servicecomponent\\-[\\.\\d]+(\\-SNAPSHOT)?\\.[wj]ar")))
        );
    }


    @Test
    public void bundleContextIsAvailable(BundleContext context)
    {
        Assert.assertNotNull("PAX Exam BundleContext available", context);
    }


    @Test
    public void sequenceServiceIsAvailable(BundleContext context)
    {
        Assert.assertNotNull("SequenceService available", fetchService(context, SequenceService.class));
    }


    @Test
    public void serviceResponseContainsThreeEchos(BundleContext context) throws Exception
    {
        final String message = "message";
        final String expected = "1 " + message + "\n2 " + message + "\n3 " + message + "\n";

        ComponentFactory factory = fetchComponentFactory(context, EchoService.FACTORY_DS);

        Dictionary<String, String> properties = new Hashtable<String, String>();
        properties.put(EchoService.REPEAT_PARAMETER, "3");
        ComponentInstance instance = factory.newInstance(properties);
        EchoService service = (EchoService) instance.getInstance();
        String actual = service.echo(message);
        Assert.assertEquals("Expected response", expected, actual);
    }


    private ComponentFactory fetchComponentFactory(BundleContext context, String componentFactoryId) throws Exception
    {
        String filter = "(component.factory=" + componentFactoryId + ")";
        ServiceReference[] references = context.getServiceReferences(ComponentFactory.class.getCanonicalName(), filter);
        return (references.length) == 0 ?  null : (ComponentFactory) context.getService(references[0]);
    }


    private <T> T fetchService(BundleContext context, Class<T> clazz)
    {
        ServiceReference reference = context.getServiceReference(clazz.getCanonicalName());
        @SuppressWarnings("unchecked")
        T service = (T) context.getService(reference);
        return service;
    }


    private String findFileInCurrentDirectoryAndBelow(final Pattern filePattern) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                Matcher matcher = filePattern.matcher(pathname.getName());
                return (matcher.matches());
            }
        };
        return findFile(new File("."), filter, filePattern);
    }


    private String findFile(File directory, FileFilter filter, Pattern filePattern) {
        File[] matches = directory.listFiles(filter);
        if(matches != null && matches.length > 0) {
            return matches[0].getAbsolutePath();
        }
        File[] subdirs = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for(final File subdir : subdirs) {
            String found = findFile(subdir, filter, filePattern);
            if(!"".equals(found)) {
                return found;
            }
        }
        throw new RuntimeException(new FileNotFoundException("No match for pattern: " + filePattern.pattern()));
    }
}