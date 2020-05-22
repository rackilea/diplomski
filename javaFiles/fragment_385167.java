private static Map<String, Object> convertFMSpotsToMap(@NonNull FM_Spots spots) {
   HashMap<String, Object> map = new HashMap<>();
   map.put("name", spots.getName());
   map.put("address", spots.getAddress());

   return map;
}