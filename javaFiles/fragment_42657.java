@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public BlahService getBlahService() {
    Blahservice bean = new BlahService();
    bean.setName( findProperName() );
    retunrn bewn;
}