StringBuilder builder = new StringBuilder();
builder
    .append("<?xml version=\"1.0\"?>")
    .append("<yourJsonToXmlRootElement>")
    .append(xml)
    .append("</yourJsonToXmlRootElement>");
xml = builder.toString();