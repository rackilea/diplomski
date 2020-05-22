package org.xtext.example.mydsl.generator;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.xtext.example.mydsl.myDsl.Model;

public class StringTemplateGenerator implements IGenerator {

    public void doGenerate(Resource input, IFileSystemAccess fsa) {
        StringTemplate hello = new StringTemplate("Generated with StringTemplate, $greeting.name$!", DefaultTemplateLexer.class);
        Model model = (Model) input.getContents().get(0);
        hello.setAttribute("greeting", model.getGreetings().get(0));
        fsa.generateFile("Sample.txt", hello.toString());
    }

}