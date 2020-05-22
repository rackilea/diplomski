Collection<JClass> typeArgClasses = new ArrayList<>();
for (String name : names()) {
    typeArgClasses.add(jCodeModel.ref(name));
}
JType jtype = jCodeModel
        .ref(typeName)
        .narrow(typeArgClasses.toArray(new JClass[typeArgClasses.size()]);