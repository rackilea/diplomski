DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
    inputFormat.setLenient(true);

    Date date = inputFormat.parse("Sat Sep 20 19:11:19 ICT 2014");
    String outputText = outputFormat.format(date);

    System.out.println(outputText);