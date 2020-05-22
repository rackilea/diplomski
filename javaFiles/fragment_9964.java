// Surface 1/3 (x, y, z - one surface for each)
Vector3d edge1 = new Vector3d();
Vector3d edge2 = new Vector3d();
Vector3d normal1 = new Vector3d();
// Get the edges, the two edges must be perpendicular to one another.
edge1.sub( point0, point1 );
edge2.sub( point0, point4 );
normal1.cross( edge1, edge2 );
normal1.normalize();