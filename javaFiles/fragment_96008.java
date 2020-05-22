Bindings.bind(
    myTextField,
    "enabled",
    new BufferedValueModel(
        new ConverterValueModel(
            pm.getModel(MyModel.MY_PROPERTY),
            new EnumMatchToEnabledConverter(MyEnum.MyValue)),
        new AbstractValueModel() {
            @Override public Object getValue() { return null; }
            @Override public void setValue(Object o) {}
        }));