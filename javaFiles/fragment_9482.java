public void create_busStop(int total,int position){
   for(int i=1; i<=total; i++){
        bus_stop_id=i;
        //System.out.println("Bus_Stop with ID:"+i+" Spawned");
        setBusPosition(i,MainClass.getPoissonRandom(position));
    }
}