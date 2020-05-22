// Your 3D render code here

float aspectRatio = Dislay.getWidth() / (float) Display.getHeight();

// will depend on your rendering implementation
// however the concept stays the same, you switch from a perspective view
// to an orthogonal view
switch_projection_matrix_to_ortho(-1 * aspectRatio, 1 * aspectRatio, -1, 1, -1, 1);

// Apply a crosshair texture
crossahir_texture.bind()
// Draw a quad
quad.draw()