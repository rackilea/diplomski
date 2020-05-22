//so we need this to get at the name of the selenium server in the global config
protected static Descriptor<? extends ComplexAxisDescriptor> getTopLevelDescriptor(){
    SeleniumAxis.DescriptorImpl sad = Jenkins.getInstance().getDescriptor(SeleniumAxis.class)
    sad.load()
    return sad
}