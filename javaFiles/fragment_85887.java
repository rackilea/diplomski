map.put("special", 100);
// correct
int special = map.get("special", Integer.class);

// incorrect and caught at compile-time     
boolean special = map.get("special", Integer.class);