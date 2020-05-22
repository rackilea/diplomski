String[] yourArray = new String[3];
yourArray[0] = "gtrd3455";
yourArray[1] = "ltzy96545";
yourArray[2] = "lopa475";

Arrays.sort(yourArray, new Comparator<String>() {
    public int compare(String str1, String str2) {
        String substr1 = str1.substring(4);
        String substr2 = str2.substring(4);

        return Integer.valueOf(substr2).compareTo(Integer.valueOf(substr1));
    }
});

System.out.println(Arrays.toString(yourArray));