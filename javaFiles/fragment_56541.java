public void addBusData(BusData busData) {
    ContentValues busValues = new ContentValues();
    busValues.put(Constants.NUMBER, busData.getmNumber());
    busValues.put(Constants.DESTINATION, busData.getmDestination());
    busValues.put(Constants.ARRIVAL_TIME, busData.getmArrivalTime());
    getWritableDatabase().insert(Constants.TABLE_NAME, null, busValues);
}