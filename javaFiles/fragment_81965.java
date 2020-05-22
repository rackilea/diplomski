transform(matrix, vector);

vector.x /= vector.w;
vector.y /= vector.w;
vector.z /= vector.w;
vector.w /= vector.w;