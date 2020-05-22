// Find the smallest point between the two
int x = Math.min(p1.x, p2.x);
int y = Math.min(p1.y, p2.y);
// Size is based on the maximum value of the two points differences...
int width = Math.max(p1.x - p2.x, p2.x - p1.x);
int height = Math.max(p1.y - p2.y, p2.y - p1.y);