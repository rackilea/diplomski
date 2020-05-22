//reusable calculation vectors
final Vector3 axis = new Vector3();
final Vector3 look = new Vector3();
final Vector3 tmp = new Vector3();

void orientLaserDecal (Decal decal, float beamWidth, Vector3 endA, Vector3 endB, Camera camera) {
    axis.set(endB).sub(endA); //the axis direction

    decal.setDimensions(beamWidth, axis.len());

    axis.scl(0.5f);
    tmp.set(endA).add(axis); //the center point of the laser

    decal.setPosition(tmp);

    look.set(camera.position).sub(tmp); //Laser center to camera. This is
        //the look vector you'd use if doing spherical billboarding, so it needs 
        //to be adjusted.
    tmp.set(axis).crs(look); //Axis cross look gives you the 
        //right vector, the direction the right edge of the sprite should be 
        //pointing. This is the same for spherical or cylindrical billboarding.
    look.set(tmp).crs(axis); //Right cross axis gives you an adjusted
        //look vector that is perpendicular to the axis, i.e. cylindrical billboarding.

    decal.setRotation(look.nor(), axis); //Note that setRotation method requires 
        //direction vector to be normalized beforehand.
}