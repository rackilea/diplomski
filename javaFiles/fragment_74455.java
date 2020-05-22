ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new SimpleModule() {

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.addBeanSerializerModifier(new CustomBeanSerializerModifier());
    }
});