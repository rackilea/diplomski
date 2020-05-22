SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");  
for(i = 40; i > 0; i--){
    Date date = new Date();
    String str = sdf.format(date);
    System.out.println(str);

    try{Thread.sleep(500);}
    catch (InterruptedException e){}
}