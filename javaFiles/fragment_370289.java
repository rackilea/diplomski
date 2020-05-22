class CurrentTheme
{
    private Dictionary<String,Object> values;

    public CurrentTheme()
    {
         values = new Dictionary<String,Object>();
    }

    public void setPropertyValue(string className, string propertyName, Object value)
    {
         values.add(className + "_" + propertyName, value);
    }

    public Object getPropertyValue(string className, string propertyName)
    {
         if (values.keyExists(className + "_" + propertyName)
         {
             return values[className + "_" + propertyName];
         }
         else
         {
             return null;
         }
    }

}