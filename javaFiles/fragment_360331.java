JClass listOfEmplType = jcodemodel.ref(List.class).narrow(jcodemodel.ref(
            Emplyee.class.getName()));
    JVar listOfEmpl = jMethodResource.body().decl(listOfEmplType, "listStr", JExpr._null());
    JClass jObjType = ((JClass) jcodemodel._ref(GenericEntity.class)).narrow(listOfEmplType);
    JVar jvobj = jMethodResource.body().decl(jcodemodel.ref(Object.class), "obj",  
            JExpr._new(jcodemodel.anonymousClass(jObjType)).arg(listOfEmpl));