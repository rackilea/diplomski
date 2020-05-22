<query connection-id="out">
    select data as "data" from dummy_table1
   <query connection-id="java">
       java.sql.Clob clob = (java.sql.Clob) get("data");
       org.xml.sax.InputSource inputSource = new org.xml.sax.InputSource(clob.getCharacterStream());
       javax.xml.xpath.XPath xpath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
      java.lang.String xpathExpression = "CommunicationCenter/Response/MenuData/Menu/Noun";

      org.w3c.dom.NodeList nodes = (org.w3c.dom.NodeList) xpath.evaluate(xpathExpression, inputSource, javax.xml.xpath.XPathConstants.NODESET);
      String someText = nodes.item(0).getTextContent();
      set("someText", someText); //Set variable for the inner script
      query.next(); //Executes inner script and make variables available to it
      <script connection-id="out">
          INSERT INTO TABLE VALUES(?someText);
      </script>
  </query>