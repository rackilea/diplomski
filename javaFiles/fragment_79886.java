if(qName.equals("coordinates")) {
    String[] splitspace = accumulator.toString().trim().split(" ");
    Segment listcoords = new Segment();

    for (String s : splitspace) {
        String[] strarray = s.split(",");
        Double strarray1 = Double.parseDouble(strarray[0]);
        Double strarray2 = Double.parseDouble(strarray[1]);
        Coordinates coord = new Coordinates(strarray1, strarray2);
        listcoords.addPoint(coord); 
    }
    // now the Segment list listcoords is complete and can be added to the global list of list
    route.addSegment(listcoords);
}