for (int i=0; i<points.size()-1; i++) {
    ArrayList<Double> distances = new ArrayList<Double>();
    for (int j=i+1; j < points.size(); j++) {
        // do your calculations here
        dist = Math.sqrt(Math.pow(points.get(i).getX() - points.get(j).getX(), 2) 
                + Math.pow(points.get(i).getY() - points.get(j).getY(), 2));   
        distances.add(dist); // add the distance to the current distances list
    }
    distArray.add(distances);  //  ***** the index of items added here *****
}