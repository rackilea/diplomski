public static List<String> getKeyName() {
    DescribeKeyPairsRequest dkpr = new DescribeKeyPairsRequest();
    DescribeKeyPairsResult dkpresult = 
    amazonEC2Client.describeKeyPairs(dkpr);

    List<KeyPairInfo> keyPairs = dkpresult.getKeyPairs();
    List<String> keyPairNameList = new ArrayList<String>();

    for (KeyPairInfo keyPairInfo : keyPairs) {
        keyPairNameList.add(keyPairInfo.getKeyName());
    }

    for (int i = 0; i < keyPairs.size(); i++) {
        System.out.println(keyPairNameList.get(i));
    }

    return keyPairNameList;
}