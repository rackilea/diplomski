public void foo() {

        final int x = 1;

        new Runnable() {


            @Override
            public void run() {
                int i = x;
            }

        };

}