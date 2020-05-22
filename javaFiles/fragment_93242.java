public Class<? extends IWidget<? extends IBaseWidget<? extends IBaseWidget<?>>>> test1() {
    return ConcreteWidget.class;
}

public Class<? extends IWidget<? extends IBaseWidget<ConcreteBaseWidget>>> test2() {
    return ConcreteWidget.class;
}

public Class<? extends IWidget<? extends ConcreteBaseWidget>> test3() {
    return ConcreteWidget.class;
}