public Map<String, String> readXmldata(String xml_debug_settings, String node)
    {

        File xml_debug_settings_file = new File(xml_debug_settings);

        if (xml_debug_settings_file.exists())
        {            
            SAXReader saxReader = new SAXReader();

            try {

                Document document = saxReader.read(xml_debug_settings_file);

                //Document temp = DocumentHelper.parseText("");  

                Element root = document.getRootElement();

                Iterator itr = root.elements().iterator();  

                Element element = null;

                while (itr.hasNext()) {  

                    Element debel = (Element) itr.next();

                    // System.out.println(debel.getName());    // node_name_1

                    if (debel.getName().equals(node)) { 

                        Iterator itrd = debel.elementIterator();

                        while (itrd.hasNext())
                        {
                            Element child = (Element) itrd.next();
                            String name = child.getName();  // node_name_2

                            int nodecount = child.nodeCount();

                            for (int i=0; i<nodecount; i++)
                            {
                                xmlarray.put(name, child.getStringValue());
                            }
                        }

                        return this.xmlarray;
                   }
                }  

            } catch (DocumentException ex) {
                Logger.getLogger(Debugsettings.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        else
        {
            JOptionPane.showMessageDialog(null, "Not exists:"  + xml_debug_settings, "Failed to open xml", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }