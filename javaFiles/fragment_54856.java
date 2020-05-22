while (sc.hasNext()) {  // loops through csv

    String csvRows = sc.next();
    // print out the line value to see what we are dealing with
    System.out.println("rawTextValue: " + csvRows);            

    // if the line is not empty
    if(!csvRows.isEmpty()) {

        String[] csvLocations = csvRows.split(",");                                 
        System.out.println(csvLocations[0] + " " + csvLocations[1]);            

        String latitude = csvLocations[0];
        double x = Double.parseDouble(latitude);                
        System.out.println("x: " + x);            

        String longitude = csvLocations[1];
        double y = Double.parseDouble(longitude);
        System.out.println("y: " + y);            
    }
 }