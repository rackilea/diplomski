private List<Taxi> taxis = new ArrayList<Taxi>();
Taxi freeTaxi = null;
Taxi scheduleTaxi(){
     for (Taxi taxi : taxis){
         if (taxi.isFree()) {
            freeTaxi = taxi;
            break; //since you already found what you want, no need to keep going.
        }
     }
    return freeTaxi;
}