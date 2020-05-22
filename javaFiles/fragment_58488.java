public static void main(String[] args) {
        long startMilli = System.currentTimeMillis();

        for(int i=0;;i++) {
            //Do something
            long timepassed = System.currentTimeMillis() -startMilli;
            if(timepassed==1000) {
                throw new RuntimeException("taking too long");
            }
        }

    }