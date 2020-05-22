Object object = datain.readObject();  // Read it once
if(object.getClass()==CarDriver.class) { 
    CarDriver carDriver1 = (CarDriver)object;
    // process carDriver1;
}
else {
    Pedestrian pedestrian1 = (Pedestrian)object; 
    // process pedestrian1
}