class GUI {

    // psuedo code ahead, warning...

    buildForm() {


        Property p = Property.getInstance(userSelectedType);
        Map m = p.getPropertyNames();
        for (entry in map) {
           // build input type
           // add listener to set values
        }
   }

   void save() {
       // run through user input map
       // call p.mapProperties(userInputMap);
   }
}