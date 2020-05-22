String deliverydate="02-SEP-2012";
SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");

Date date=sdf.parse(deliveryDate);

sdf=new SimpleDateFormat("MM/dd/yyyy");
System.out.println(sdf.format(date));