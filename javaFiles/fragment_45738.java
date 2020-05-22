String partValueContentType = part.getContentType();
System.out.println(partValueContentType);

if (!(partValueContentType.equals("image/jpeg")
        || partValueContentType.equals("image/jpg")
        || partValueContentType.equals("image/gif")
        || partValueContentType.equals("image/png")))
{
    FacesMessage msg = new FacesMessage("File is not an image.",
            "Acceptable image types (jpeg, jpg, gif, png)");
    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    throw new ValidatorException(msg);
}