ArrayList<List<String>> bulkUploadList = new ArrayList<List<String>>();
    ArrayList<List<String>> result = new ArrayList<List<String>>();

    HashSet<String> hashSet = new HashSet<>();

    for(List<String> item : bulkUploadList) {
        String title = item.get(1);
        String tags = item.get(2);
        String uniqueString = (title + "#" + tags).trim().toUpperCase();

        if(!hashSet.contains(uniqueString)) {
            result.add(item);
            hashSet.add(uniqueString);
        } else {
            System.out.println("Filtered element " + uniqueString);
        }
    }