// pseudocode, not the actual GeoTools API
boolean isWater(Coordinate point) 
{
    ShapeDataStore countryShapes = loadShapeData("world.shp");

    GeoShape shape = countryShapes.findShapeByPoint(point);

    if (shape == null)
        return true // not a country or Antarctica, must be international waters.
    else
        return false;
}