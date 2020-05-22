SimpleHash globalModel = new SimpleHash();
TemplateHashModel enumModels = BeansWrapper.getDefaultInstance().getEnumModels();
TemplateHashModel myEnumModel = (TemplateHashModel) enumModels.get("your.fully.qualified.enum.MyEnum");

globalModel.put("MyEnum", myEnumModel);
freemarkerConfiguration.setAllSharedVariables(globalModel);