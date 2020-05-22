class CustomIclusionStrategy implements ExclusionStrategy {

private Class classToIclude;

private Field[] declaredFields;


private List<FieldAttributes> fields;

public CustomIclusionStrategy(List<FieldAttributes> fields) {
    this.fields = fields;
}

public CustomIclusionStrategy(Class classToIclude) {
    this.classToIclude = classToIclude;
    this.declaredFields=classToIclude.getDeclaredFields();

}

// called only if shouldSkipClass returns false
@Override
public boolean shouldSkipField(FieldAttributes f) {

    try {
        classToIclude.getSuperclass().getDeclaredField(f.getName());
        System.out.println(f.getName());
        return true;
    } catch (Exception e) {
    } 
    return false;

}

@Override
public boolean shouldSkipClass(Class<?> clazz) {
    // if returns false shouldSkipField will be called, otherwise 
 //shouldSkipField will not be called
    return false;
}
}