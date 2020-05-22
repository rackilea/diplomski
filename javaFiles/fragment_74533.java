public Vector4f worldSpaceToDeviceCoords(Vector4f pos){
    temp4f.set(pos);
    Matrix4f projection = transformation.getProjectionMatrix(FOV, screenWidth,screenHeight,1f,MAXVIEWDISTANCE);
    Matrix4f view = transformation.getViewMatrix(camera);
    view.transform(temp4f); //Multiply the point vector by the view matrix
    projection.transform(temp4f); //Multiply the point vector by the projection matrix


    temp4f.x = ((temp4f.x / temp4f.w) + 1) / 2f; //Convert x coordinate to range between 0 to 1
    temp4f.y = ((temp4f.y / temp4f.w) + 1) / 2f; //Convert y coordinate to range between 0 to 1

    //Logarithmic depth buffer z-value calculation (Get rid of this if not using a logarithmic depth buffer)
    temp4f.z = ((2.0f * (float)Math.log(LOGDEPTHCONSTANT * temp4f.z + 1.0f) /
            (float)Math.log(LOGDEPTHCONSTANT * MAXVIEWDISTANCE + 1.0f)) - 1.0f) * temp4f.w;

    temp4f.z /= temp4f.w; //Perform perspective division on the z-value
    temp4f.z = (temp4f.z + 1)/2f; //Transform z coordinate into range 0 to 1

    return temp4f;
}