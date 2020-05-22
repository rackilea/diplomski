public MyBeanProcessor extends NotUnderControlBeanPostProcessor {
....
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (thisBeanIsOfConcernToMe(bean, beanName){
          return super.postProcessBeforeInitialization(bean, beanName)
        }else{
             return bean;
        }
    } 
}