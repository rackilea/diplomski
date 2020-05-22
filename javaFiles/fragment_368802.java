// Replaces gluPerspective. Sets the frustum to perspective mode.
// fov     - Field of vision in degrees in the y direction
// aspect   - Aspect ratio of the viewport
// zNear    - The near clipping distance
// zFar     - The far clipping distance
private static void perspectiveGL(float fov, float aspect, float zNear, float zFar) {
    float fH = (float) Math.tan(fov / 360 * Math.PI) * zNear;
    float fW = fH * aspect;
    glFrustum( -fW, fW, -fH, fH, zNear, zFar );
}