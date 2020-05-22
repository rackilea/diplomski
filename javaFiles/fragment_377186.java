JobDataMap data = new JobDataMap();
    data.put("message", "Prvy"); //Correct

    JobDataMap data2 = new JobDataMap();
    data2.put("message", "Druhy");// Correct

    JobDataMap data3= new JobDataMap();
    data.put("message", "3");// Here not data3 but data

    JobDataMap data4 = new JobDataMap();
    data.put("message", "stvrty");// Here not data4 but data

    JobDataMap data5 = new JobDataMap();
    data.put("message", "5"); // Here not data5 but data

    JobDataMap data6 = new JobDataMap();
    data.put("message", "xsiesty6");  // Here not data6 but data