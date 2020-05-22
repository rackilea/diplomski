package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.antlr.stringtemplate.StringTemplate
import org.antlr.stringtemplate.language.DefaultTemplateLexer
import org.xtext.example.mydsl.myDsl.Model

class MyDslGenerator implements IGenerator {

    override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        val hello = new StringTemplate("Generated with StringTemplate, $greeting.name$!", typeof(DefaultTemplateLexer))
        val model = resource.contents.head as Model
        hello.setAttribute("greeting", model.greetings.head)
        fsa.generateFile("Sample.txt", hello.toString())
    }
}