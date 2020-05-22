package test

import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.TransformationContext
import java.util.Date

@Active(MyAnnotationProcessor)
annotation MyAnnotation
{
}

class MyAnnotationProcessor extends AbstractClassProcessor
{
    override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context)
    {
        annotatedClass.addMethod("generatedMethod") [
            body = '''«Date.newTypeReference» date = new Date();'''
        ]
    }
}