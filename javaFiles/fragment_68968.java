EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
eAttribute.setName("myAttribute");
eAttribute.setEType(EcorePackage.eINSTANCE.getEEList());
// This is the interesting part:
EGenericType eGenericTypeArgument = ecoreFactory.createEGenericType(); // line 1
eGenericTypeArgument.setEClassifier(EcorePackage.eINSTANCE.getEString()); // line 2
eAttribute.getEGenericType().getETypeArguments().add(eTypeArgument); // line 3