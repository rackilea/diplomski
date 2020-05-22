public class StepBuilderIteration {

    interface NextChecker {
        NextGetter hasNext();
    }

    interface NextGetter {
        Object next();
        NextChecker more();
    }

    static class ArrayExample {
        final static Integer[] ints = new Integer[] { 1, 2, 3, 4 };

        public static NextChecker iterate() {
            return iterate( 0 );
        }

        private static NextChecker iterate( final int i ) {
            return new NextChecker() {
                public NextGetter hasNext() {
                    if ( i < ints.length ) {
                        return new NextGetter() {
                            public Object next() {
                                return ints[i];
                            }
                            public NextChecker more() {
                                return iterate( i+1 );
                            }
                        };
                    }
                    else {
                        return null;
                    }
                }
            };
        }
    }

    public static void main(String[] args) {
        NextChecker nc = ArrayExample.iterate();
        while (nc != null) {
            NextGetter ng = nc.hasNext();
            if (ng != null) {
                System.out.println(ng.next());
                nc = ng.more();
            }
        }
    }
}