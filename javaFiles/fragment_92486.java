Collections.sort(teamsToOrder,new Comparator<String[]>() {
    public int compare(String[] s1, String[] s2) {

        return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
    }
});