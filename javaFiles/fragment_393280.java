LinkedHashMap<String, String> Tmap = 
    users.stream()
         .collect(Collectors.toMap(UserMst::getLoginId,
                                   UserMst::getTenantString,
                                   (x, y)-> x + ", " + y,
                                   LinkedHashMap::new));