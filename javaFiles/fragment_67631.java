print("<class>")
foreach(file in files)
  {
  mysaxparser.parse(new Handler() 
     {
     content="";

     void endElement(tag)
         {
          if(tag.equals("student")) print("<student>"+escapeXML(content)+"</student>"); 
         content="";
         }
     void characters(str)
         {
         content+=str;
         }
     },file);
  }
print("</class>");