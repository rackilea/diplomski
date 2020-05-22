public static void main(String args[]) {
        String line = "IDENTIFIER: 115956 LATITUDE: 40.104730 LONGITUDE: -88.228798 DATE RIGHTS"; 
        String pattern = "IDENTIFIER:\\s(\\d*)\\sLATITUDE:\\s(\\d*\\.?\\d*)\\sLONGITUDE:\\s(.*?)\\s";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

        if (m.find()) {
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }