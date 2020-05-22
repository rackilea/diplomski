if(otlGoLiveDate.after(ovr.getOvrStartDate())){
  ovr.setOvrStatus(OverrideData.ERROR);
  status = false;
  ovr.setOvrMessage("Cannot enter overrides before go live date.");
  throw new Exception("an error occurred");
}