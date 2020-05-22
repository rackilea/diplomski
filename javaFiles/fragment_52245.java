String query = "SELECT TOP 1 * FROM Vehicles v " +
        "JOIN Bikelots l ON l.BikeLotId = v.BikeLotId " +
        "JOIN BikeTypes b ON b.BikeTypeId = l.BikeTypeId " +
        "WHERE b.BikeTypeId = ?1 " +
        "ORDER BY " +
        "Geography\\:\\:STGeomFromText(v.Point.MakeValid().STAsText(),4326) " +
        ".STDistance(Geography\\:\\:STGeomFromText(Geometry\\:\\:Point(?2,?3,4326).MakeValid().STAsText(),4326)) ";
    @Query(value = query, nativeQuery = true)