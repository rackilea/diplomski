if(area(coordinate)<70.0){
     features.remove(firstFeature);
     // removing the polygon moves j+1 to j, so we need to leave j alone
 } else {
     j++; // this polygon is OK, move to the next one
 }