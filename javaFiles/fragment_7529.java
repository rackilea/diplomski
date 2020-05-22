attribute vec4 s_vPosition;
attribute vec4 s_vColor;
varying vec4 color;

void main() {
    color = s_vColor;
    gl_Position = s_vPosition;
}