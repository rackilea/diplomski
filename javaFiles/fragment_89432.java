public final class AdapterUtil
{
  /**
   * Get adapter for an object.
   * This version checks first if the object is already the correct type.
   * Next it checks the object is adaptable (not done by the Platform adapter manager).
   * Finally the Platform adapter manager is called.
   *
   * @param adaptableObject Object to examine
   * @param adapterType Adapter type class
   * @return The adapted object or <code>null</code>
   */
  public static <AdapterType> AdapterType adapt(Object adaptableObject, Class<AdapterType> adapterType)
  {  
    // Is the object the desired type?

    if (adapterType.isInstance(adaptableObject))
      return adapterType.cast(adaptableObject);

    // Does object adapt to the type?

    if (adaptableObject instanceof IAdaptable)
     {
       AdapterType result = adapterType.cast(((IAdaptable)adaptableObject).getAdapter(adapterType));
       if (result != null)
         return result;
     }

    // Try the platform adapter manager

    return adapterType.cast(Platform.getAdapterManager().getAdapter(adaptableObject, adapterType));
  }
}