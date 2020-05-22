int eventType = parser.getEventType(); 
String extensionElementName = parser.getName();
StringBuilder extensionBuilder = new StringBuilder();
String element = "";

while(!(eventType == XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase(extensionElementName))) {
    if(eventType == XmlPullParser.END_TAG && parser.getText().equalsIgnoreCase(element)) {
        // this is for elements which are closed immediately like the following example: <sample />
        // otherwise, this line would be added twice
    } else {
        extensionBuilder.append(parser.getText());
    }

    element = parser.getText();
    eventType = parser.next();
}

// append closing element
if(!parser.getText().equalsIgnoreCase(element)) 
    extensionBuilder.append(parser.getText());