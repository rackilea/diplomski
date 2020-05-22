DateFormat df=new SimpleDateFormat("dd/MM/yy");
    Date birthDay=df.parse("29/07/13");
    Date currentDay=new Date();
    Calendar cal1=Calendar.getInstance();
    Calendar cal2=Calendar.getInstance();
    cal1.setTime(birthDay);
    cal2.setTime(currentDay);
    int years=cal2.get(Calendar.YEAR)-cal1.get(Calendar.YEAR);
    if(3>years){
        System.out.println("Infant");
    }else if(years<13){
        System.out.println("Child");
    } else{
        System.out.println("adult");
    }