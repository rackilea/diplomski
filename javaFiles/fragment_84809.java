@Override
public <C> IWrapModel<C> wrapOnInheritance(Component component)
{
    IWrapModel<C> actualModel = super.wrapOnInheritance(component);
    if (actualModel.getObject() instanceOf LocalDate) {
        return new LocalDateModelButAlsoWrapping(actualModel);
    } else {
        return actualModel;
    }
}