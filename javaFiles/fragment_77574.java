public Cube(int height, int width, int depth) {
    super(height, width); // cube_height, cube_width are defaulting to 0.
    cube_depth = depth;
    cube_height = height; // <-- you called it cube_height, not just height.
    cube_width = width;
}