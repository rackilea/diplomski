String date = "2014-05-03";
    List<String> dateList = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (int i = 0; i < 6; i++) {

        Date dateParsed = sdf.parse(date);
        dateParsed.setDate(dateParsed.getDate() - i);
        dateList.add(sdf.format(dateParsed));
    }