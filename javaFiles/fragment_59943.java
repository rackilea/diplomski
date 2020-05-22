@Bean
public BeanA getBeanA(){
 return BeanA();
}

@Bean
public BeanB getBeanB(BeanA beanA){
 return BeanB(beanA);
}

@Bean
public BeanC getBeanC(BeanA beanA, BeanB beanb){
 return BeanC(beanA, beanB);
}