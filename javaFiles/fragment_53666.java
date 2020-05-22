public static void main(String args[]){
     XMLInputFactory factory = XMLInputFactory.newInstance();
         // I made only below path change to read the xml file from my windows machine
   File file = new File("C:/LocalWorkSpace/Test/src/Test1.xml");
   ArrayList<String> listFruit = new ArrayList<>();
      try {
         XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(file));
         while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    System.out.println("We are on an element " + reader.getLocalName());


                    if(reader.getLocalName().equals("OptnTp")){
                       reader.next();
                       listFruit.add( reader.getCharacterEncodingScheme());
                       System.out.println("\t -> Fruit recovered! ");
                    }
                    break;
            }
            if(listFruit.size() > 2){
               System.out.println("\t --> Number of fruit> 1 => end of loop!");
               break;
            }
        }

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
            System.out.println(listFruit.get(0));

   }