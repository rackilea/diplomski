@Bean
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
protected PictureBean createPictureBean(Picture picture) {
    PictureBean bean = new PictureBean();
    bean.setPicture(picture);
    return bean;
}