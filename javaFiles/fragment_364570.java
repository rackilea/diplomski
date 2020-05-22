SimpleVector diff = this.getPosition().calcSub(ref);
SimpleVector s = rotateAround(center, ref, (float) angle);
s.x += diff.x;
// Rotation only on a plane (2 axis)
s.y = this.getPosition().y;
s.z += diff.z;
this.positioningObject(s);