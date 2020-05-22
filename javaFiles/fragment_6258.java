Calendar ini = Calendar.getInstance();
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {e.printStackTrace();}

    Calendar end = Calendar.getInstance();
    long diff = end.getTimeInMillis()-ini.getTimeInMillis();
    System.out.println("diff "+diff);
    System.out.println("ini date "+ ini.getTime());
    System.out.println("end date "+ end.getTime());
    Date date = new Date(diff);
    System.out.println(date);
    timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    System.out.println("diff time format "+timeFormat.format(date));