protected void inject(Object target,
                      @Nullable String requestingBeanName, 
                      @Nullable PropertyValues pvs)
                throws Throwable {

            if (this.isField) {
                Field field = (Field) this.member;
                ReflectionUtils.makeAccessible(field);
                field.set(target, getResourceToInject(target, requestingBeanName));
}