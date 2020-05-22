public class ReattachingEntityManagerFactoryFactory {


    @SuppressWarnings("rawtypes")
    public static EntityManagerFactory createContainerEntityManagerFactory(
    PersistenceUnitInfo info, Map map) {
        Ejb3Configuration cfg = new Ejb3Configuration();

        Ejb3Configuration configured = cfg.configure( info, map );

        handleClassMappings(cfg, map);

        return configured != null ? configured.buildEntityManagerFactory() : null;
    }

    @SuppressWarnings("rawtypes")
    private static void handleClassMappings(Ejb3Configuration cfg, Map map) {
        Iterator clsMappings = cfg.getClassMappings();
        while(clsMappings.hasNext()){
             PersistentClass mapping = (PersistentClass) clsMappings.next();
             handleProperties(mapping.getPropertyIterator(), map);
        }
    } 



    private static void handleProperties(Iterator props, Map map) {

        while(props.hasNext()){
             Property prop = (Property) props.next();
             Value value = prop.getValue();
             if (value instanceof Component) {
                 Component c = (Component) value;
                 handleProperties(c.getPropertyIterator(), map);
             } else {

                 handleReturnUtilDateInsteadOfTimestamp(prop, map);

             }
         }

    private static void handleReturnUtilDateInsteadOfTimestamp(Property prop, Map map) {
        if ("true".equals(map.get("hibernate.return.date.instead.of.timestamp"))) {
            Value value = prop.getValue();

            if (value instanceof SimpleValue) {
                SimpleValue simpleValue = (SimpleValue) value;
                String typeName = simpleValue.getTypeName();
                if ("java.util.Date".equals(typeName)) {
                    UtilDateSimpleValue udsv = new UtilDateSimpleValue(simpleValue);
                    prop.setValue(udsv);
                }
            }
        }
    }

}