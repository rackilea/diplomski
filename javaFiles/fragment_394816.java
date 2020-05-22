public static Vector closest(Vector target, List<Vector> list) {
    Vector closest = list.get(0);                                 //this variable will kep track of the closest vector we have found yet. We simply start with the first one

    for(int i = 1; i < list.size(); i++) {                        //loop over the list, skipping the first entry
        Vector curr = list.get(i);                                //get the current vector from the list
        if (target.distanceTo(curr) < target.distanceTo(closest))    //if the current vector is closer to target than the closest one yet
            closest = curr;                                       //keep the current vector as the new closest one
    }

    return closest;                                               //return the resulting vector
}