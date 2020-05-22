//Take the existing list from the map using hospitalId
ArrayList<Doctor> existingList = hMap.get(hospitalId);

Doctor d = new Doctor();
// add new doctor to existingList
existingList.add(d);

//put the new list again in the map

hMap.put(hospitalId,existingList);