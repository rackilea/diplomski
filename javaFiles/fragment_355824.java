class AdapterFactory implements IAdapterFactory
{
  @Override
  public Object getAdapter(Object adaptableObject, Class adapterType)
  {
    if (adaptableObject instanceof MyObject && adapterType == MyObject.class)
      {
        ... convert from 'adaptableObject' to MyObject
        return myobject;
      }

    return null;
  }

  @Override
  public Class<?> [] getAdapterList()
  {
    return new Class<?> [] {MyObject.class};
  }
}