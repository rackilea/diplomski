@Override
public int compare(Circle o1, Circle o2) {
    //you may want to consider cases where one circle or both are null 
    if (o1.getRadius() > o2.getRadius()) {
        return o1.getRadius();
    } else if (o1.getRadius() == o2.getRadius()) {
        return 0;
    }           
       return o2.getRadius();
    }   
}