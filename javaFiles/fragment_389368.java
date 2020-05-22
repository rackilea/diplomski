public static void main(String[] args) {

        List<DataRow> mData = new ArrayList<>();
        mData.add(new DataRow("Saeid", 28, "blabla"));
        mData.add(new DataRow("Alice", 23, "blablablaaa"));
        mData.add(new DataRow("Frederiek", 26, "blasasaasasasas"));

        //You have to define your own comparator for the DataRow object
        //For descending it will be like this:
        mData.sort(new Comparator<DataRow>() {
            @Override
            public int compare(DataRow o1, DataRow o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("NAME\tAGE\tADDRESS");
        for(DataRow dr:mData) {
            System.out.println(dr.getRow());
        }
}