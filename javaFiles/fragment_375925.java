public String computeGeomFromLongitudeLatitude() {
    Session session = getSession();
    SQLQuery q =  session
            .createSQLQuery(
                    "select ST_GeometryFromText('POINT(10 10)',4326) as geom");
    q.addScalar("geom", StringType.INSTANCE); 
    String result = (String) q.list().get(0);

    closeSession();

    return result;
}