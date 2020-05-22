uniform mat4 uMVPMatrix;

attribute vec4 vPosition;
attribute vec3 vColor;

varying vec3 color;

void main() {
    gl_Position = uMVPMatrix * vPosition;
    color = vColor;
}