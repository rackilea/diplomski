public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

    public void registerCustomEditors(PropertyEditorRegistry registry) {
         registry.registerCustomEditor(StringWrapper.class, new StringWrapperEditor());   
    }
}