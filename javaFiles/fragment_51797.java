private Comparator<YourClass> getComparator(MyPropertiesEnum myEnum) {
   return new Comparator<YourClass>() {

      @Override
      public int compare(YourClass o1, YourClass o2) { {
         switch (myEnum) {
            case FIRSTNAME:
               // implementation for firstname
            break;
            case LASTNAME:
              // implementation for lastname
            break;
            default:
               // implementation for default version
            break;           
         }
      }
   };
}