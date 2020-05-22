String partValueContentType = part.getContentType();
System.out.println(partValueContentType);
Set<String> acceptedMimeTypes = new HashSet<>(Arrays.asList("image/jpeg", "image/jpg", "image/gif", "image/png"));

if (!acceptedMimeTypes.contains(partValueContentType))
{
    FacesMessage msg = new FacesMessage("File is not an image.",
            "Acceptable image types " + Arrays.toString(acceptedMimeTypes.toArray()));
    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    throw new ValidatorException(msg);
}