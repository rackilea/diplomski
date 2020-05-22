@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface MyClassType {
    ClassImplName value();
}

public enum ClassImplName {
    CLASS_ONE(MyClassOne.class),
    CLASS_TWO(MyClassTwo.class);

    private Class<? extends MyInterface> classType;

    private ClassImplName(Class<? extends MyInterface> clazz) {
        this.classType = clazz;
    }

    public Class<? extends MyInterface> getClassType(){
        return classType;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface ClassType {
    ClassImplName value();
}