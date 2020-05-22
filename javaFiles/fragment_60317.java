public Camera(Vector3f pos, Vector3f forward, Vector3f up)
{
    this.pos = pos;
    this.forward = forward;
    this.up = up;

    up.normalize();
    forward.normalize();
}