public void ToXml(object value, Type expectedType, 
    XStreamWriter writer, MarshallingContext context)
{
    context.convertAnother(new MatrixDTO( matrix ));
}

public Object FromXml(Type expectedType, 
    XStreamReader reader, UnmarshallingContext context)
{
    return context.convertAnother(context.currentObject(), MatrixDTO.class);
}