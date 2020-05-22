public void loadFile(File m_imageFile)
{
   try
   {
     ZipFile zipFile = new ZipFile(m_imageFile);

     ZipEntry xmlZipFile = zipFile.getEntry("xml");

     byte[] buffer = new byte[10000];
     zipFile.getInputStream(xmlZipFile).read(buffer);
     String xmlString = new String(buffer);
     Xml xmlRoot = Xml.parse(xmlString.substring(0, xmlString.lastIndexOf('>')+1));
     for(List<Xml> iter = xmlRoot.getNestedXml(); iter != null; iter = iter.next())
     {
       String layerName = iter.element().getAttributes().getValueByName("name");
       m_view.getCanvasPanel().getLayers().add( 
           new Layer(ImageIO.read(zipFile.getInputStream(zipFile.getEntry(layerName))), 
               Integer.valueOf(iter.element().getAttributes().getValueByName("x")),
               Integer.valueOf(iter.element().getAttributes().getValueByName("y")),
               Integer.valueOf(iter.element().getAttributes().getValueByName("w")),
               Integer.valueOf(iter.element().getAttributes().getValueByName("h")),
               Integer.valueOf(iter.element().getAttributes().getValueByName("z")),
               iter.element().getAttributes().getValueByName("name"))
        );
     }
     zipFile.close();
   } catch (FileNotFoundException e)
   {
     System.out.println("FileNotFoundException in MainController.loadFile()");
     e.printStackTrace();
   } catch (IOException e)
   {
       System.out.println("IOException in MainController.loadFile()");
       e.printStackTrace();
   }