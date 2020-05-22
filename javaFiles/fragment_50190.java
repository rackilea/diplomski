void setperspectivemat(float[] mat, float near, float far, float fov)
{

 float scale = 1 / Math.tan(Math.toRadians(fov * 0.5));
 mat[0] = scale;
 mat[5] = scale;
 mat[10] = - far / (far - near);
 mat[11] = - far * near / (far - near);
 mat[14] = - 1;
 mat[15] = 0;
}