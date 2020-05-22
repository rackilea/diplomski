boolean addHeaderElements = true;
if (Util.getPortalRequestContext() != null && Util.getPortalRequestContext().getExtraMarkupHeaders() != null)
{
    for (Element markupHeaderElement : Util.getPortalRequestContext().getExtraMarkupHeaders())
    {
        if (markupHeaderElement.getTagName().equalsIgnoreCase("meta") &&
            markupHeaderElement.getAttribute("name") != null &&
            markupHeaderElement.getAttribute("name").equalsIgnoreCase("project-name"))
        {
            addHeaderElements = false;
            break;
        }
    }
}