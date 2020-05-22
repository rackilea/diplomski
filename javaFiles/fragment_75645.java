@Usage('Example using spring.beanfactory')
@Command
def mycommand(InvocationContext context, ...) {
    BeanFactory beans = context.attributes['spring.beanfactory']
    YourBean bean = beans.getBean(YourBean.class);
    ...
}