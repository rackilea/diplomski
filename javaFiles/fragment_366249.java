// Vertex Shader
attribute vec4 inColor;
varying vec4 vColor;
attribute vec4 vPosition;
void main() {
  gl_Position = vPosition;
  vColor = inColor;
}

// Fragment Shader
varying vec4 vColor;
void main() {
    gl_FragColor = vColor;
}