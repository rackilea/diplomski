Field[] fields = MyConstantsPool.class.getFields();
for (int i = 0; i < fields.length; i++) {
    Field f = fields[i];
    if ( ConstantEntity.class.isAssignableFrom(f.getType())
            && Modifier.isStatic(f.getModifiers()) ) {
        ConstantEntity constant =
            (ConstantEntity) f.get(null);
    }
}