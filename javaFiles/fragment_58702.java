public boolean foodPhysics(){
    Rectangle rect = new Rectangle(fx,fy,15,15) //the size of your food.
    if(rect.contains(head)){                    //you'll need to create this variable 
       return true;
    }
    return false;
}