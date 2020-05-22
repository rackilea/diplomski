public String readXml(URL url) throws ParserConfigurationException, MalformedURLException, IOException, SAXException
    {
      //...
      //Declare listaKursow here
      String listaKursow = "";
      for(int i = 0; i<children.getLength();i++)
      {
        //..
           for (int j = 0; j<childrenPozycja.getLength(); j++)
            {
                Node childPozycja = childrenPozycja.item(j);
                if (childPozycja instanceof Element)
                {
                    String nameChf = "CHF";
                    Double kurs;
                    Element childPozycjaElement = (Element) childPozycja;
                    String listaKursowTemp = childPozycjaElement.getTextContent();

                    //System.out.println(listaKursow);

                    //return value of listaKursow
                    listaKursow = listaKursow + listaKursowTemp;
                }
            }
      }
      return listaKursow;
    }