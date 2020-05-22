tenAppDTO.getTAP_PROPOSED_START_DATE()=2009-11-01  
tenAppDTO.getTAP_PROPOSED_END_DATE()=2013-11-29                                                                         
ReadableInstant r=new DateTime(tenAppDTO.getTAP_PROPOSED_START_DATE());
ReadableInstant r1=new DateTime(tenAppDTO.getTAP_PROPOSED_END_DATE());
Period period = new Period(r, r1, PeriodType.yearMonthDay());   //Change here  
period.normalizedStandard(PeriodType.yearMonthDay());
years =  period.getYears();
month=period.getMonths();
day=period.getDays();   
out.println("year is-:"+years+"month is -:"+ month+"days is -:"+ day);