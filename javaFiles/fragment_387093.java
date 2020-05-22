EnumMap<DayOfWeek , LocalTime> dayToTimeMap = new EnumMap<> ( DayOfWeek.class );

dayToTimeMap.put ( DayOfWeek.TUESDAY , LocalTime.parse ( "20:00" ) );
dayToTimeMap.put ( DayOfWeek.WEDNESDAY , LocalTime.of ( 15 , 0 ) );
dayToTimeMap.put ( DayOfWeek.THURSDAY , LocalTime.parse ( "20:00" ) );
dayToTimeMap.put ( DayOfWeek.FRIDAY , LocalTime.parse ( "18:00" ) );
dayToTimeMap.put ( DayOfWeek.SATURDAY , LocalTime.parse ( "15:00" ) );