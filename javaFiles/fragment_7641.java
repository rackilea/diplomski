Car currentCar = getCurrentCar();
RoadElement re = currentCar.getLocation();
if (re instanceof Road){
  //can we drive "forward and backward?"
  if ((Road)re).getPrevious() != null){

  }

  if ((Road)re).getNext() != null){

  }
}else if (re instanceof Intersection){
   //check available outgoing roads
   if ((Intersection)re).getNorthernConnection() != null){

   }
   ...
}