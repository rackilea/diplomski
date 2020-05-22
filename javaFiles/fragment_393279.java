LinkedHashMap<String, String> Tmap = 
    users.stream()
         .collect(Collectors.toMap(UserMst::getLoginId,
                                   u -> convert(u.getTenantId()),
                                   (x, y)-> x + ", " + y,
                                   LinkedHashMap::new));