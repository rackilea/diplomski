package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.xtext.example.mydsl.myDsl.Model

class MyDslGenerator implements IGenerator {

    override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        val model = resource.contents.head as Model
        fsa.generateFile("Sample.txt", '''
            Generated with Xtend, «model.greetings.head»!
        ''')
    }
}