<T extends ICINGBean> BeanListHandler<T> makeContainer(Class<T> beanClass) {
    return new BeanListHandler<T>(beanClass);
}

...

handler = makeContainer(beanClass);