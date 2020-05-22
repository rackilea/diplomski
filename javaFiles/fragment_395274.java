private SessionFactory sessionFactory;

@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
    Object object = null;

    if (StringUtils.isNotBlank(value)) {
        try {
            int underscoreIndex = value.indexOf("_");
            String className = value.substring(0, underscoreIndex);
            String id = value.substring(underscoreIndex + 1, value.length());

            Class<?> clazz = Class.forName(className);
            object = getSessionFactory().getCurrentSession().get(clazz, Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    return object;
}

@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
    String result = null;

    if (value != null && !value.equals("")) {
            Integration obj = (Integration) value;
            result = Hibernate.getClass(obj).getName() + "_" + obj.getId();
        }
    return result;
}

private SessionFactory getSessionFactory() {
    if(sessionFactory == null) {
        sessionFactory = ((SessionFactory) FacesContextUtils                    .getWebApplicationContext(FacesContext.getCurrentInstance())
                .getBean("sessionFactory"));
    }

    return sessionFactory;
}