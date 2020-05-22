SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat sdfOut = new SimpleDateFormat("yyyyMMdd");

String dob = "1985-03-01";
Date dt = sdfIn.parse(dob);
dob = sdfOut.format(dt);

System.out.println(dob);