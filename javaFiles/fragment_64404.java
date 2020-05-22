public void printByName(String val) {
    int i = 0;
    for (CompactDisc values : database.values()) {
        if (values.getArtist().contains(val)) {
            System.out.println(values);
            i++;
        }  
    }
    if (i==0) {
        System.out.println("No CDs found for " + val);
    }
}