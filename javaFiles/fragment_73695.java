private Vector2 getPointOnLine(Vector2 v1, Vector2 v2, float distance) 
{
    double length = Math.hypot(v1.x - v2.x, v1.y - v2.y);
    distance /= length;
    return v1.cpy().lerp(v2, distance);

}