String input = "2017-08-01T15:43:45+0530";

SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

Date date = parser.parse(input);

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

System.out.println(formatter.format(date));