Iterator<Map<String, String>> iterator = placesLived.iterator(); 

while (iterator.hasNext()) {
    Map<String, String> place = iterator.next();
        for (Map.Entry<String, String> entry : place.entrySet()) {
            String placeVar1 = entry.getKey();
            String placeVar2 = entry.getValue();
             // TODO 
        }
    }
}