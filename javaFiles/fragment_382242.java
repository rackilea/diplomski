Calendar mDummyDate;
mDummyDate = Calendar.getInstance();
mDummyDate.set(mDummyDate.get(Calendar.YEAR), 11, 31);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
String formattedDate = dateFormat.format(mDummyDate.getTime());
System.out.println(formattedDate);