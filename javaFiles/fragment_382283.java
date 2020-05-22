public class BeanFactory {

public <BeanT extends ILoadableBean> BeanT create(final Class<BeanT> beanClass) {
return LoadableBeanFactory.getInstance().create(beanClass);
    }

}