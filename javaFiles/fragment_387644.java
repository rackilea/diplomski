Integer locId = null;

if(newObservation.getLocationId() != null) {
 locId = new Integer(newObservation.getLocationId());
 if(locId == 0) {
   locId = null;
 }
}