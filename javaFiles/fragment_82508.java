ApplicationAssociate application = ApplicationAssociate.getInstance(FacesContext.getCurrentInstance().getExternalContext());
BeanManager beanManager = application.getBeanManager();
Map<String, BeanBuilder> beanMap = beanManager.getRegisteredBeans();
Set<Entry<String, BeanBuilder>>beanEntries = beanMap.entrySet();

for (Entry<String, BeanBuilder> bean: beanEntries) {
  String beanName = bean.getKey();
  if (beanManager.isManaged(beanName)) {
    BeanBuilder builder = bean.getValue();
    System.out.println("Bean name: " + beanName);
    System.out.println("Bean class: " + builder.getBeanClass());
    System.out.println("Bean scope: " + builder.getScope());
  }
}