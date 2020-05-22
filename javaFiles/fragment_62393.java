@Configuration
public class Config {

    @Bean
    public DerivedTestBean() {
        DerivedTestBean bean = new DerivedTestBean();
        initTestBean(bean);
        bean.setName("override");
        return bean;
    }

    private void initTestBean(TestBean testBean) {
        testBean.setName("parent");
        testBean.setAge(1);
    } 
}