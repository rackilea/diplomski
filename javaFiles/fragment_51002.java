public class ContentTypeModelTransform implements Transform<ContentTypeModel>
{
    @Override
    public ContentTypeModel read(String value) throws Exception
    {
        // The special case of 'image/jpeg'
        if( value.equalsIgnoreCase("image/jpeg") == true )
        {
            return ContentTypeModel.image_jpeg;
        }
        else // The default case - use enums valueOf()
        {
            return ContentTypeModel.valueOf(value);
        }
    }


    @Override
    public String write(ContentTypeModel value) throws Exception
    {
        // The special case of 'image/jpeg' - same as in read(), but opposite direction
        if( value == ContentTypeModel.image_jpeg ) 
        {
            return "image/jpeg"; 
        }
        else
        {
            return value.toString();
        }
    }

}