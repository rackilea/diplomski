String inputDateTime = "20150211152026.0Z";
        String[] parts = inputDateTime.split("[.]");
        String dateTimePart = parts[0];
        String timeZonePart = "+0" + parts[1].substring(0, parts[1].length() - 1) + "00";
        DateFormat originalFormat = new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = originalFormat.parse(dateTimePart+timeZonePart);
        String formattedDate = targetFormat.format(date);  
        System.out.println(formattedDate);