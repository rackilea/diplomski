PlainDate today = SystemClock.inLocalView().today();

HijriCalendar umalqura = 
  today.transform(HijriCalendar.class, HijriCalendar.VARIANT_UMALQURA);
HijriCalendar westIslamicCivil = 
  today.transform(HijriCalendar.class, HijriAlgorithm.WEST_ISLAMIC_CIVIL);

System.out.println(umalqura); // AH-1437-07-23[islamic-umalqura]
System.out.println(westIslamicCivil); // AH-1437-07-22[islamic-civil]