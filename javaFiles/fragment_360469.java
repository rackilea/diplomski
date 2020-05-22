float distZ = ....; // distance of the camera to the image
float sizeX = ....; // width of the rectangle where the image is placed in
float sizeY = ....; // height of the rectangle where the image is placed in

float near = 1f;
float far  = 10f;

float left   = -0.5 * sizeX * near / distZ;
float right  =  0.5 * sizeX * near / distZ;
float bottom = -0.5 * sizeY * near / distZ;
float top    =  0.5 * sizeY * near / distZ;

Matrix.frustumM(projectionMatrix, 0, left, right, bottom, top, near, far);