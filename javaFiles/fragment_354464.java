Date wrongDate = new Date(dateFormat.parse("2017-10-20").getTime()); // 0026-04-09
    Date correctDate = corrections.get(wrongDate);
    if (correctDate == null) {
        System.out.println("Could not find correction for " + wrongDate);
    } else {
        System.out.println(correctDate);
    }