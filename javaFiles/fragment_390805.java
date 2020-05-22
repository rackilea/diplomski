// Vertex
#version 420 core
layout(location=0) in vec2 pos;     // glVertex2f <-1,+1>
out smooth vec2 p;                  // texture end point <0,1>
void main()
    {
    p=pos;
    gl_Position=vec4(pos,0.0,1.0);
    }