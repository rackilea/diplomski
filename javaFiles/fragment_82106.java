JAnnotationUse oneToMany = field.annotate(OneToMany.class);
//...snipped...
    try {
        oneToMany.param("targetEntity", Class.forName(jpaProperty.getTargetEntity()));
    } catch (ClassNotFoundException ex) {
        try {
            Class targetEntityClass = generateDummyClass(jpaProperty.getTargetEntity());
            oneToMany.param("targetEntity", targetEntityClass);
        } catch (CannotCompileException compileEx) {
            throw ex;
        }
    }
}