package org.xtext.example.mydsl.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.xtext.example.mydsl.myDsl.Element
import org.xtext.example.mydsl.myDsl.MyDslPackage
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.naming.QualifiedName

class MyDslScopeProvider extends AbstractMyDslScopeProvider {

    override getScope(EObject context, EReference reference) {
        if (reference == MyDslPackage.Literals.MEMBER_REFERENCE__MEMBER) {
            val element = EcoreUtil2.getContainerOfType(context, Element)
            if (element != null)  {
                val type = element.type.type
                if (type instanceof JvmDeclaredType) {
                    return Scopes.scopeFor(type.declaredFields, [QualifiedName.create(simpleName)], IScope.NULLSCOPE)
                }
            }
            return IScope.NULLSCOPE
        }
        super.getScope(context, reference)
    }

}