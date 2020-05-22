public Vector2f projectPoint(Vector3f position){
    temp4f.set(worldSpaceToDeviceCoords(temp4f.set(position.x,position.y,position.z, 1)));
    temp4f.x*=screenWidth;
    temp4f.y*=screenHeight;

    //If the point is not visible, return null
    if (temp4f.w < 0){
        return null;
    }


    return temp2f.set(temp4f.x,temp4f.y);

}