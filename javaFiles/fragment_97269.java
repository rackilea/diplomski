for (String line; (line = br.readLine()) != null;) {
    // String delims = "[,]";
    // String[] parsedData = line.split(delims);

    //Split and assign the values to a new BattingOrder object here either in a 
    //constructor for BattingObject or here and pass in the values from the file
    unsortList.add(new BattingOrder(line));
}