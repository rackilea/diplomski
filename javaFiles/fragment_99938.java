JAXBContext context = JAXBContext.newInstance(TopLevelObject.class);
    Unmarshaller u = context.createUnmarshaller();

    Reader reader = new StringReader(
            "<topLevelObject>\r\n" + 
            "  <entityVersionInfo>\r\n" + 
            "        <id>111111</id>\r\n" + 
            "        <version>1</version>\r\n" + 
            "  </entityVersionInfo>\r\n" + 
            "</topLevelObject>");
    Object o = u.unmarshal(new InputSource(reader ));
    System.out.println(o);