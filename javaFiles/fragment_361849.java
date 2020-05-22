/**
 * Create a regular polygon around a radius. Useful for creating circles and the like.
 * 
 * @param origin {OpenLayers.Geometry.Point} center of polygon.
 * @param radius {Float} distance to vertex, in map units.
 * @param sides {Integer} Number of sides. 20 approximates a circle.
 * @param rotation {Float} original angle of rotation, in degrees.
 * @return Polygon
 */
public static native JSObject jsCreateRegularPolygon(JSObject origin, Float radius, Integer sides, Float rotation)
/*-{
    return $wnd.OpenLayers.Geometry.Polygon.createRegularPolygon(origin, radius, sides, rotation);
}-*/;