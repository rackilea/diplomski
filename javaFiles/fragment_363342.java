attribute vec3 a_position;
attribute vec3 a_normal;
uniform mat4 mvpMatrix;  // mvp = ModelViewProjection
uniform mat4 mvMatrix; // mv = ModelView
uniform mat3 normalMatrix;
uniform vec3 vLightPosition;

varying vec3 vVaryingNormal;
varying vec3 vVaryingLightDir;

void main(void) {
    vVaryingNormal = normalMatrix * a_normal;
    vec4 vPosValue = vec4(a_position.x, a_position.y, a_position.z, 1.0);
    vec4 vPosition4 = mvMatrix * vPosValue;
    vec3 vPosition3 = a_position;
    vVaryingLightDir = normalize(vLightPosition - vPosition3);
    gl_Position = mvpMatrix * vPosValue;
}