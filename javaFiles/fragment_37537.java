@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void upload(FormDataMultiPart formParams)
{
    Map<String, List<FormDataBodyPart>> fieldsByName = formParams.getFields();

    // Usually each value in fieldsByName will be a list of length 1.
    // Assuming each field in the form is a file, just loop through them.

    for (List<FormDataBodyPart> fields : fieldsByName.values())
    {
        for (FormDataBodyPart field : fields)
        {
            InputStream is = field.getEntityAs(InputStream.class);
            String fileName = field.getName();

            // TODO: SAVE FILE HERE

            // if you want media type for validation, it's field.getMediaType()
        }
    }
}