public void add(String planeId, int capacity) {
    int flag=0;
    for(Airport air:airport) {
       if(air.planeID.equals(planeID)) {
            air.capacity=capacity;
            flag=1;
       }

    }
    if(flag==0)
       airport.add(new Airport(planeId, capacity));
}