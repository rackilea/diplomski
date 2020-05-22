String caseDate = "Tuesday , December 25th, 1900";
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEEE , MMMM dd'th', yyyy");
        Date date = inputFormat.parse(caseDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        System.out.println(formattedDate);