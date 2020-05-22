//Only images can be there in CSS.
Pattern URL_PATTERN = Pattern.compile("http://.*?jpg|jpeg|png|gif");
for (int j = 0; j < styleDeclaration.getLength(); j++) {
    String property = styleDeclaration.item(j); 
    String value = styleDeclaration.getPropertyCSSValue(property).getCssText();

    Matcher m = URL_PATTERN.matcher(value);
    //CSS property can have multiple URL. Hence do it in while loop.
    while(m.find()) {
        String originalUrl = m.group(0);
       //Now you've the original URL here. Change it however ou want.
    }
}