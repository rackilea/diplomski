public int compare(String o1, String o2) {
            String s1 = o1.substring(0, 3);
            String s2 = o2.substring(0, 3);
            if(!s1.equals(s2)) {
                return s1.compareTo(s2);
            }
            String[] fields1 = o1.substring(3).split("[^0-9]", 2);
            String[] fields2 = o2.substring(3).split("[^0-9]", 2);
            int i1 = Integer.parseInt(fields1[0]);
            int i2 = Integer.parseInt(fields2[0]);
            if(i1 != i2) {
                return i1 - i2;
            }
            String r1 = "";
            if(fields1.length > 1) {
                r1 = fields1[1];
            }
            String r2 = "";
            if(fields2.length > 1) {
                r2 = fields2[1];
            }
            return r1.compareTo(r2);
        }