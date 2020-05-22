ArrayList<LocationHourListHB> locationHoursList = new ArrayList<LocationHourListHB>();

ListIterator<LocationHourListHB> iterator = locationHoursList.listIterator();

while(iterator.hasNext(){
LocationHourListHB locationHour = iterator.next()
  if(hoursTO.getStartTime().equalsIgnoreCase(locationHour.getStartTIme()) && hoursTO.getEndTime().equalsIgnoreCase(locationHour.getEndTime()))
        {
            break;
        }
        else
        {
            LocationHourListHB locationHourListHB = new LocationHourListHB();
            locationHourListHB.setStartTIme(hoursTO.getStartTime());
            locationHourListHB.setEndTime(hoursTO.getEndTime());
            iterator.add(locationHourListHB);
        }

}