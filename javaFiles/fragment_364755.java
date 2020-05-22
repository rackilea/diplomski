public GeoProfileVo findById (String id){
    ObjectId oid = new ObjectId(id);
    return getDs().find(GeoProfileVo.class).field("id").equal(oid).get();
}

public String saveGeoProfile(GeoProfileVo geoProfileVo){
    return getDs().save(geoProfileVo).getId().toString();
}