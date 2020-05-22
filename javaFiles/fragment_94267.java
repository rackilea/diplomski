public void bookTaxi(String isTaxi){
    //book a taxi
    Taxi getTaxi;
    String nowGetTaxi;
    for (int i = 0; i < taxiList.size(); i++) 
    {
        getTaxi = taxiList.get(i);
        nowGetTaxi = getTaxi.getNo();

        if (isTaxi.equals(nowGetTaxi)) 
        {
            getTaxi.setbooked(true);
        }
    }

}