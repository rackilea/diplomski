DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    System.out.println(df.format(date));
    long milSec=date.getTime();
    long addMilSec=123*60*1000;

    long sum=milSec+addMilSec;
    Date d=new Date(sum);

    System.out.println(df.format(d));