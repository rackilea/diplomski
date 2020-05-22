<T, U> Form<U> createForm(Component<T, U> component, T object, String prefix)
{
    return component.createForm(component.get(object), prefix + subPrefix);
}

--
    Component<T, ?> component = e.getValue();

    Form<?> form = createForm(component, object, prefix + subPrefix);