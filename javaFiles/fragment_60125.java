public class Equavalenarray {
    public static void main(String[] args) {
            System.out.println(equivalentArrays(new int[]{0,1,2}, new int[]{2,0,1}));
            System.out.println(equivalentArrays(new int[]{0,1,2,1}, new int[]{2,0,1}));
            System.out.println(equivalentArrays( new int[]{2,0,1}, new int[]{0,1,2,1}));
            System.out.println(equivalentArrays( new int[]{0,5,5,5,1,2,1}, new int[]{5,2,0,1}));
            System.out.println(equivalentArrays( new int[]{5,2,0,1}, new int[]{0,5,5,5,1,2,1}));
            System.out.println(equivalentArrays( new int[]{0,2,1,2}, new int[]{3,1,2,0}));
            System.out.println(equivalentArrays( new int[]{3,1,2,0}, new int[]{0,2,1,2}));
            System.out.println(equivalentArrays( new int[]{1,1,1,1,1,1}, new int[]{1,1,1,1,1,2}));
            System.out.println(equivalentArrays( new int[]{ }, new int[]{3,1,1,1,1,2}));
            System.out.println(equivalentArrays( new int[]{ }, new int[]{ }));

        }

        public static int equivalentArrays(int[] a1, int[] a2) {
            if(a1==null && a2==null) return 0;
            boolean found;

            for(int i : a1) {
                found = false;
                for(int j : a2) {
                    if(i==j) {
                        found = true;
                        break;
                    }
                }

                if(found==false) {
                    return 0;
                }
            }

            for(int i : a2) {
                found = false;
                for(int j : a1) {
                    if(i==j) {
                        found = true;
                        break;
                    }
                }

                if(found==false) {
                    return 0;
                }
            }
            return 1;
        }
    }
}