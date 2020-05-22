for (final Object[] objects : evntList) {
                final EvntDTO dto = new ExactTargetDailyMailDTO(
                        String.valueOf(objects[0]),
                        String.valueOf(objects[1]),....,....,);

  if(dto.getEvntName() matches some condition(){
  //change event name and other params accordingly
  }
  eventList.add(dto);