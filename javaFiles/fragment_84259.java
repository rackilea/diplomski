public static ArrayList<Integer> lengths(ArrayList<String> list) {
        ArrayList<Integer> lengthList = new ArrayList<Integer>();
        for (String s : list)
            lengthList.add(s.length());
        return lengthList;
}