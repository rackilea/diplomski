public void deleteDogsFromKennels(Map<Kennel, List<Dog>> mapOfKennelsAndDogs) {
    //For each Kennel in the Map
     for (Map.Entry<Kennel, List<Dog>> entry :mapOfKennelsAndDogs.entrySet()){
        String key = entry.getKey().getId();
        List<Dog> dogList = entry.getValue();
        try{
           dogRepository.deleteDogs(dogList);
        }
        catch(Exception ex){
            //log failed to delete kennel with key
         }
     }
   }