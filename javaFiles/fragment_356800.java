import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * @author dietrich - Initial contribution and API
 */
public class Main {

    public static void main(String[] args) {
        // TODO traverse directory
        List<String> files = Lists.newArrayList("model/a.dmodel", "model/b.dmodel");
        Injector injector = new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet rs = injector.getInstance(ResourceSet.class);
        ArrayList<Resource> resources = Lists.newArrayList();
        for (String file : files) {
            Resource r = rs.getResource(URI.createFileURI(file), true);
            resources.add(r);
        }

        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        for (Resource r : resources) {
            List<Issue> issues = validator.validate(r, CheckMode.ALL, CancelIndicator.NullImpl);
            for (Issue i : issues) {
                System.out.println(i);
            }
        }

        GeneratorDelegate generator = injector.getInstance(GeneratorDelegate.class);
        JavaIoFileSystemAccess fsa = injector.getInstance(JavaIoFileSystemAccess.class);
        fsa.setOutputPath("src-gen-code/");
        GeneratorContext context = new GeneratorContext();
        context.setCancelIndicator(CancelIndicator.NullImpl);

        for (Resource r : resources) {
            generator.generate(r, fsa, context);
        }
    }

}