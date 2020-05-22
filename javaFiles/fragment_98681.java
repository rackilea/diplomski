for (V neighbor : super.neighbors(v1)){ 
    if (!neighbor.visited ){ //if the neighbor is not visited before
        if (isReachableHelper(neighbor, v2, path)) { //recursive call
            return true; // we found a path!
        }
    }
}