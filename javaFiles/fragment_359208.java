public static void main(String[] args){
    List<RoadLinkRecord> records = parse("path\\to\\RoadLink.csv");

    // display all the records
    for (RoadLinkRecord record : records) {
        System.out.println(record);
    }
}