public static class Inner
   {

      private String type;


      private String value;

      @XmlAttribute
      public String getType()
      {
         return type;
      }
      // setter setType

      @XmlValue
      public String getValue()
      {
         return value;
      }   
      // setter setValue
   }