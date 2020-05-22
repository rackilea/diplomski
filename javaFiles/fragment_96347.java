private void getUrl() {
String result = null;
String dest1 = list.get(0);
String dest2 = list.get(1);
String dest3 = list.get(2);
String start = getAddress();

    String urls = "https://maps.googleapis.com/maps/api/distancematrix/json?";
    try {
        encodedString = urls + "origins="
                + URLEncoder.encode(start, "utf8")+"|"
                + URLEncoder.encode(dest1, "utf8")+"|"
                + URLEncoder.encode(dest2, "utf8")+"|"
                + URLEncoder.encode(dest3, "utf8")
                +"&destinations="
                + URLEncoder.encode(dest1, "utf8")+"|"
                + URLEncoder.encode(dest2, "utf8")+"|"
                + URLEncoder.encode(dest3, "utf8")+"|"
                + URLEncoder.encode(start, "utf8")
                +"&mode=driving"
              // this is the mistake 
                +"&language = en-En"  
              //correct form is
                +"&language = en"
                +"&key="+API_KEY;
        encodedString = encodedString.replaceAll("%2C","+");
        encodedString = encodedString.replaceAll("\\++", "+");

    }