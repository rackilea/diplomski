point[] Intersect(Sphere s , Circle3D c)
{
    /*
      first we check if sphere even intersects with plane of c
      I assume you know how to implement some if these functions
    */
    if(GetDistanceOfPointFromPlane(s.center , new Plane(c.center , normal))>s.radius)
         return NULL;

    /*
      again we check possibility of avoiding math of intersection
    */
    point dir = Normalize(s.center - c.center);
    if(!DoesRayIntersectWithSphere(s , new Ray(c.center , c.radius*dir)))
        return NULL;

    /*
      this is the ugly part of code that unfortunately is deep trig math.
      you must describe sphere and circle equations in polar system , then
      you must solve sphere = circle
      I hope the link below be helpful 
    */  

}