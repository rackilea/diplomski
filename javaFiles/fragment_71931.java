Collections.sort(attachmentFiles,new Comparator<String>() {
    public int compare(String o1, String o2) {
         int point1 = o1.indexOf('.');
         // If no point is present we assume it is present as last position
         if (point1 == -1) {
             point1 = o1.length();
         }
         int point2 = o2.indexOf('.');
         // If no point is present we assume it is present as last position
         if (point2 == -1) {
             point2 = o2.length();
         }
         if (point1 > point2) {
             char[] chars = new char[point1-point2];
             Arrays.fill(chars, '0');
             o2 = new String(chars) + o2;
         } else if (point1 < point2) {
             char[] chars = new char[point2-point1];
             Arrays.fill(chars, '0');
             o1 = new String(chars) + o1;
         }
         return o1.compareTo(o2);
    }
});