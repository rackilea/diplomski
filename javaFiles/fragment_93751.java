if(rectangle.contains(triangleCenter)){
        if(rectangle.contains(triangleLowerRightCorner)){
            if(rectangle.contains(triangleLowerLeftCorner)){
                if(rectangle.contains(triangleTopCorner)){
                    return true;
                }
            }
        }
    }