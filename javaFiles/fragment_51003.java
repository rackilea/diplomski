// Create a matcher - it's so small, you can implement it that way ...
final Matcher matcher = new Matcher()
{
    @Override
    public Transform match(Class type) throws Exception
    {
        /*
         * If it's that enum, simple has to use the new transformer
         * instead of the enum default one.
         */
        if( type.equals(ContentTypeModel.class) == true )
        {
            return new ContentTypeModelTransform();
        }

        return null;
    }
};


Serializer ser = new Persister(matcher); // Set matcher in the ctor
// Everything else is as usual
ItemLink il = ser.read(ItemLink.class, xml);