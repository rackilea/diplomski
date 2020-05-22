uniform mat4 trans;
attribute vec3 vertex;

void main()
{
    gl_Position = trans * vec4(vertex, 1.0);
}