@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(AnnotationImplementationClass.class)
public @interface MyCustomAnnotation {
    public String field1();
    public String[] list1();
}


@SpringBootApplication
@MyCustomAnnotation(field1 = "field1 value", list1 = { "list1 value 1", "list1 value 2" })
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}

public class AnnotationImplementationClass implements ApplicationContextAware
{
    private String field1;
    private String[] list1;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        // Grab the beans from the app context that are annotated with my custom annotation
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(MyCustomAnnotation.class);
        Collection<Object> beans = beanMap.values();

        // There is a possibility that multiple beans are annotated with the annotation. I only annotated one bean
        // but I am using a "for" loop for illustration.
        for (Object bean : beans)
        {
            // Spring annotated classes are often proxied when Spring is initializing. I found that I was unable to get
            // the annotation and its parameter values from the proxy instance. I need to find the actual class that was
            // annotated using the the proxy as a start point. The following "if" clause illustrates the process.
            Class<? extends Object> annotatedClass = null;
            if (bean instanceof TargetClassAware)
            {
                annotatedClass = ((TargetClassAware) bean).getTargetClass();
            }
            else if (ClassUtils.isCglibProxy(bean))
            {
                annotatedClass = bean.getClass().getSuperclass();
            }
            else
            {
                annotatedClass = bean.getClass();
            }

            // Now I can get the annotation and its parameter values
            MyCustomAnnotation annotation = annotatedClass.getAnnotation(MyCustomAnnotation.class);
            field1 = annotation.field1();
            list1 = annotation.list1();

            // Since I only want one of the classes annotated by my custom annotation I break out of the loop
            break;
        }
    }
}