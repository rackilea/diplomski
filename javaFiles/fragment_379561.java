@Mapping( target = "address", source = "completeAddress")
RelationListDTO relationToListDto(Relation relation);

// MapStruct will know to use this method to map between a `String` and `List<Address>`
default List<Address> mapAddress(String relation){
      //create new arraylist
      // create new AddressObject and set completeAddress to address.city
     // add that to list and return list

}