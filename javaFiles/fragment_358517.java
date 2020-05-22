String defaultAppearance = textField.getDefaultAppearance(); // usually like "/Helv 12 Tf 0 0 1 rg"
Pattern p = Pattern.compile("\\/(\\w+)\\s(\\d+)\\s.*");
Matcher m = p.matcher(defaultAppearance);
if (!m.find() || m.groupCount() < 2)
{
    // oh-oh
}
String fontName = m.group(1);
int fontSize = Integer.parseInt(m.group(2));
PDAnnotationWidget widget = textField.getWidgets().get(0);
PDResources res = widget.getAppearance().getNormalAppearance().getAppearanceStream().getResources();
PDFont fieldFont = res.getFont(COSName.getPDFName(fontName));
if (fieldFont == null)
{
    fieldFont = acroForm.getDefaultResources().getFont(COSName.getPDFName(fontName));
}
System.out.println(fieldFont + "; " + fontSize);