final List<PersonDetails> listWithAddress =
    new ArrayList<PersonDetails>();
final List<PersonDetails> listWithDescription =
    new ArrayList<PersonDetails>();
// fill both lists with data

final Map<String, PersonDetails> map =
    // map sorted by name, change to HashMap otherwise
    // (or to LinkHashMap if you need to preserve the order)
    new TreeMap<String, PersonDetails>();

for(final PersonDetails detailsWithAddress : listWithAddress){
    map.put(detailsWithAddress.getName(), detailsWithAddress);
}
for(final PersonDetails detailsWithDescription : listWithDescription){
    final PersonDetails retrieved =
        map.get(detailsWithDescription.getName());
    if(retrieved == null){
        map.put(detailsWithDescription.getName(),
            detailsWithDescription);
    } else{
        retrieved.setDescription(detailsWithDescription.getDescription());
    }
}