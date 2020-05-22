f = normalize(target - position);
s = normalize(cross(f, up));
u = normalize(cross(s, f));

mat4 mat = mat4(1.0f);

mat.data[0] = s.x;
mat.data[4] = s.y;
mat.data[8] = s.z;

mat.data[1] = u.x;
mat.data[5] = u.y;
mat.data[9] = u.z;

mat.data[2] = -f.x;
mat.data[6] = -f.y;
mat.data[10] = -f.z;

mat.data[3] = 0.0f;
mat.data[7] = 0.0f;
mat.data[11] = 0.0f;

mat.data[12] = -dot(s, position);
mat.data[13] = -dot(u, position);
mat.data[14] = dot(f, position);
mat.data[15] = 1.0f;