//while inside 
 JSONArray data = obj.getJSONArray("response");
 for (int i = 0; i < data.length(); i++) {

    //temp boolean
    Boolean isFound = false;

    for (TrackingModel Item : Items) {

      if(Item.id().toString().contains(id)){

         //already in ArrayList, skip adding
         //set temp boolean as true as we found a match
         isFound = true;

      }


   }

   //now we check temp boolean isFound is false, so we can run add();
   if(!isFound ){

        TrackingModel reg = new TrackingModel();                                                            
        reg.setId(id);
        Items.add(reg);

   }

}
//end of for (int i = 0; i < data.length(); i++)