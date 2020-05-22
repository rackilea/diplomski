public class SomeClass {
private final BeanFactory beanFactory;

public SomeClass(BeanFactory beanFactory)  {
this.beanFactory= beanFactory;
}

public void doSth() {
beanFactory.create(...);
}

}