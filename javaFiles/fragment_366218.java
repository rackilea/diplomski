public LinkedList<Calendar> days = new LinkedList<Calendar>();

private void calculateCreditReturn(){

   Calendar tempC = Calendar.getInstance();
    for(int x=0; x<10; x++){
        tempC.add(Calendar.DAY_OF_YEAR, 30);
        Calendar forStore = (Calendar) tempC.clone();
        days.add(forStore);
    }
}