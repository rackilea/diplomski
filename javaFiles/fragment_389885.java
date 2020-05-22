Bundle bundle = getIntent().getExtras();
String CurrentSupporters = bundle.getInt("CurrentSupporters"); 
Syste.out.println("CurrentSupporters : "+CurrentSupporters);
String MaxSupporters = bundle.getInt("MaxSupporters"); 
String RegularPrice = bundle.getInt("RegularPrice"); 
String DiscountPrice = bundle.getInt("DiscountPrice");