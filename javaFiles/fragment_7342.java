float dot(Vector2f b){

    return (getX()*b.getX()) + (getY()*b.getY());
}

float mod(){

    return sqrt((getX()*getX()) + (getY()*getY()));
}