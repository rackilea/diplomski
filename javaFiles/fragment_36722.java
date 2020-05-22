if(checkEastCell() != wall){
   moveNorthEast();
}
else if(checkNorthCell() != wall){
   moveNorthEast();
}
else{
   pathingFailure(); 
}