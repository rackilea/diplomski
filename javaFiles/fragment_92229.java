enum CPoint {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }


    and test it like:

        public static void main(String[] args) {
        final int divisor = 360 / CPoint.values().length;
        for (int i = 0; i < 360; i++) {
            final int coci = i / divisor;
            final int resto = i % divisor;
            if (resto <= divisor / 2) {
                System.out.println(i + "--->" + CPoint.values()[coci % CPoint.values().length]);
            } else {
                System.out.println(i + "--->" + CPoint.values()[(coci + 1) % CPoint.values().length]);

            }
        }
    }