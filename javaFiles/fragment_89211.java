Object object = datain.readObject();
if (object instanceof CarDriver) {
   CarDriver carDriver1 = (CarDriver)object;
   // process carDriver1;
}
else if (object instanceof Pedestrian) {
    Pedestrian pedestrian1 = (Pedestrian)object; 
    // process pedestrian1
}