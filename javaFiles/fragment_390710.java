float ti = 2.56f;   // equals 2 hours and 56 minutes

    int hr = (int)(ti * 100) / 100;
    int min = (int)(ti * 100) % 100;
    System.out.println(hr);
    System.out.println(min);

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR, hr);
    cal.set(Calendar.MINUTE, min);
    System.out.println(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));