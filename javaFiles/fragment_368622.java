public class ComparatorClass implements Comparator<List<String>>{

            private int compare(String s1, String s2) {
                boolean b1 = s1.matches(".*[^0-9.\\-].*");
                boolean b2 = s2.matches(".*[^0-9.\\-].*");

                // if both are gonna find doubles
                if (!b1 && !b2) {
                    Double d1 = Double.parseDouble(s1);
                    Double d2 = Double.parseDouble(s2);

                    return d1.compareTo(d2);
                }
                // if both are text, then compare as strings
                else if (b1 && b2) {
                    return s1.compareTo(s2);
                }
                // otherwise return one or the other, depending on which is text/number
                else return b2 ? -1 : 1;
            }


        @Override
        public int compare(List<String> o1, List<String> o2) {
            for(int i=0;i<Math.min(o1.size(), o2.size()); i++) {
                int comparedAtThisLevel=compare(o1.get(i),o2.get(i));
                if(comparedAtThisLevel!=0)
                    return comparedAtThisLevel;
            }
            return Integer.compare(o1.size(),o2.size());
        }
    }