// We get the estructuralfeature
EStructuralFeature feature = eobj.eClass().getEStructuralFeature("myfeature");
// Is the feature type "primitive"
if (feature.getEType() instanceof EDataType) {
    EDataType dtype = (EDataType)ea.getEType();
    // We get the EFactory
    EFactory factory = feature.getEType().getEPackage().getEFactoryInstance();
    eobj.eSet(feature, factory.createFromString(dtype, "mystringvalue"));
}