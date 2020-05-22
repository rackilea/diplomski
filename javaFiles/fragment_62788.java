Date start = new Date();
SimpleDateFormat sdfm = new SimpleDateFormat("mm");
SimpleDateFormat sdfs = new SimpleDateFormat("ss");

Date now = new Date();

if(sdfm.format(new Date(now.getTime() - start.getTime())).equals("00")){
JOptionPane.showMessageDialog(null, "You Won!! It only took you " + sdfs.format(new Date(now.getTime() - start.getTime())) + " Seconds", "You Won!!", 1);
    }else{  
JOptionPane.showMessageDialog(null, "You Won!! It only took you " + sdfm.format(new Date(now.getTime() - start.getTime())) +  ":" + sdfs.format(new Date(now.getTime() - start.getTime())) + " Minutes", "You Won!!", 1);
System.exit(0);