public static List<String> sortOldSchool(List<String> list){

    Comparator<String> comparator = new Comparator<String>(){
        private static final String LETTER = "Letter.pdf";
        public int compare(String orange, String apple){
            String ostart = orange.substring(0,3);
            String astart = apple.substring(0,3);
            if (ostart.equals(astart)){
                if (orange.endsWith(LETTER)){
                    return (apple.endsWith(LETTER)) ? 0 : -1;
                }
                else return (apple.endsWith(LETTER)) ? 1 : orange.compareTo(apple);
            }
            else return ostart.compareTo(astart);
        }
    };
    Collections.sort(list, comparator);
    return list;
}