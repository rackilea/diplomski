Circle3D Intersect(Sphere s1 , Sphere s2)
{
     double d = dist(s1.center , center)
     double x = (d*d + s1.r*s1.r - s2.r*s2.r)/(2*d)
     Point normal = normalize(s2.Center - s1.Center)
     Point center = s1.center + x*normal;
     double radius = sqrt(s1.r*s1.r - x*x)

     return new Circle3D(center , radius , normal);
}