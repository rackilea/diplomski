public class TestJavaClassTreeConstruct {

    /**
     * To test everything works
     */
    @Test
    @SuppressWarnings("rawtypes")
    public void testLoadingClassList() {
        Class inputSingleClass = ExportTagsResource.class;
        Set<Class> list = getEjbAnnotatedClassTree(inputSingleClass);
        for (Class class1 : list) {
            System.err.println(class1.getName());
        }
    }

    /**
     * Returns the ejb classes sufficient to complete the EJB injection class
     * tree starting from the class "inputSingleClass"
     * 
     * @param inputSingleClass
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Set<Class> getEjbAnnotatedClassTree(Class inputSingleClass) {
        Set<Class> classes = new HashSet<Class>();
        classes.add(inputSingleClass);
        return getEjbAnnotatedClassTree(classes);
    }

    /**
     * Gets the ejb class tree starting from a list of classes.
     * 
     * @param classList
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Set<Class> getEjbAnnotatedClassTree(Set<Class> classList) {
        boolean found = false;
        List<Class> tempList = new ArrayList<Class>();

        for (Class innerClass : classList) {

            for (Field field : innerClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(EJB.class)) {
                    if (!classList.contains(field.getType())) {
                        tempList.add(field.getType());
                        found = true;
                    }
                }
            }
        }
        classList.addAll(tempList);
        if (found) {
            classList.addAll(getEjbAnnotatedClassTree(classList));
        }
        return classList;
    }
}