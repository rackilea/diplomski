Map<Integer, List<ObjectLocation>> myLocationMap = new HashMap<>();
List<ObjectLocation> currentList = myLocationMap.get(oneLocation.locationID);
if(currentList == null) {
    // We haven't stored anything at this locationID yet,
    // so create a new List and add it to the Map under
    // this locationID value.
    currentList = new ArrayList<>();
    myLocationMap.put(oneLocation.locationID, currentList);
}
currentList.add(oneLocation);