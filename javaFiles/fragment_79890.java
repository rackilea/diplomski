Map<Integer, List<PoI>> poisPerId = new HashMap<>();
for (PoI poi : _POIs){
    Integer id = poi.getId();
    List<PoI> pois = poisPerId.get(id);
    if(pois == null){
        pois = new ArrayList<PoI>();
        poisPerId.put(id, pois);
    }
    pois.add(poi);
}