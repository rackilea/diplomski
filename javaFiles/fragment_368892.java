public class DBCustomExpressionRegistration implements BeanFactoryAware {

@Override
public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    if (beanFactory instanceof ConfigurableBeanFactory) {
        ConfigurableBeanFactory cbf = (ConfigurableBeanFactory) beanFactory;
        cbf.setBeanExpressionResolver(new StandardBeanExpressionResolver(){
            @Override
            protected void customizeEvaluationContext(
                    StandardEvaluationContext evalContext) {
                evalContext.addMethodResolver(new InfraReflectiveMethodResolver());
            }
        });
    }

}

public String getDbConfig(String param){
    Configuration configuration  = ConfigurationFactory.getConfiguration();             
    @SuppressWarnings("unchecked")
    Iterator<String> keys = configuration.getKeys();
    while(keys.hasNext()){
        String key = keys.next();
        String value = configuration.getString(key);
        String tempKey = "database.*."+param;
        if (key.matches(tempKey)){
            return value;
        }
    }

    throw new IllegalArgumentException("could find pattern for: database.<string>" + param);
}


private class InfraReflectiveMethodResolver extends ReflectiveMethodResolver {

    @Override
    public MethodExecutor resolve(EvaluationContext context, Object targetObject, String name, List<TypeDescriptor> argumentTypes) throws AccessException {

        if ("getDbConfig".equals(name)){
            return new DBMethodExecutor();
        }
        return super.resolve(context, targetObject, name, argumentTypes);
    }

}

private class DBMethodExecutor implements MethodExecutor {

    @Override
    public TypedValue execute(EvaluationContext context, Object target, Object... arguments) throws AccessException {

        try {
            return new TypedValue(getDbConfig((String)arguments[0]), new TypeDescriptor(new MethodParameter(DBCustomExpressionRegistration.class.getDeclaredMethod("getDbConfig",new Class[] { String.class }), -1)));
        }
        catch (Exception ex) {
            throw new AccessException("Problem invoking method: getDbConfig" , ex);
        }

    }

}