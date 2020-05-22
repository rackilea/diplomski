for (Field field : model.getClass().getFields())
{
    Object fieldObject = field.get(model);
    if (fieldObject instanceof BeanSet)
    {
        BeanSet beanSet = (BeanSet) fieldObject;
        //checks if the set is loaded or not
        if (beanSet.isReference())
        {
            field.set(model, null);
        }
    }
 }