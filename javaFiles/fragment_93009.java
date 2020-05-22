List<String> res = new ArrayList<String>();

for (String crtKey : map.keySet()) {
    Integer value = map.get(crtKey);

    if ( value != null && value > 10) 
        res.add(crtKey);
    }
}