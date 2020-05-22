Calendar cal = Calendar.getInstance();
//cal.setTime(new Date());//Set specific Date if you want to

for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
    cal.set(Calendar.DAY_OF_WEEK, i);
    System.out.println(cal.getTime());//Returns Date
}