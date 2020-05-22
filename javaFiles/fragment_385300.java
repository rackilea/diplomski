Com4jObject obj = iTestParameterFactory.addItem(new Variant(Variant.Type.VT_NULL));
iTestParameter = obj.queryInterface(ITestParameter.class);
iTestParameter.name("AAB");
iTestParameter.defaultValue("BBB");
iTestParameter.description("CCC");
iTestParameter.post();