for (int t = 0; t < numIndices / 3; ++t)
{
    unsigned int t1 = dataIndices[t*3+0];
    unsigned int t2 = dataIndices[t*3+1];
    unsigned int t3 = dataIndices[t*3+2];
    const vec3f& a = verts[t1];
    const vec3f& b = verts[t2];
    const vec3f& c = verts[t3];
    vec3f u = b - a;
    vec3f v = c - a;
    vec3f n = u.cross(v);
    //if (n.size() > 0.0) n.normalize(); //removes weighting based on triangle area
    norms[t1] += n;
    norms[t2] += n;
    norms[t3] += n;
}
for (int v = 0; v < numVertices; ++v)
    norms[v].normalize();