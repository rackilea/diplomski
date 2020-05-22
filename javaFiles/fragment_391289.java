public class database {
     private static PersistentObject storeVenue;
     static final long key = 0x2ba5f8081f7ef332L;
     public Hashtable hashtable;
     public Vector venue_list;

     public database() {
        storeVenue = PersistentStore.getPersistentObject(key);
     }

     public void save(Document xml) {
        venue_list = new Vector();
        storeVenue.setContents(venue_list);

        Hashtable categories = new Hashtable();

        try {

           xml.getDocumentElement().normalize();

           NodeList list = xml.getElementsByTagName("element");

           for (int i = 0; i < list.getLength(); i++) {

              String category = "";
              String name = "";
              NodeList children = list.item(i).getChildNodes();
              for(int j = 0; j < children.getLength(); ++j)
              {
                 Node n = children.item(j);
                 if("category_id".equals(n.getNodeName()))
                    category = n.getTextContent();
                 else if("name".equals(n.getNodeName()))
                    name = n.getTextContent();
              }

              categories.put(category, name);

              System.out.println("category=" + category + "; name=" + name);
           }

        } catch (Exception e) {
           System.out.println(e.toString());
        }

        venue_list.addElement(categories);

        storeVenue.commit();
     }
  }