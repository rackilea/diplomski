int getMyRandomResId() {

     int imag = rand.nextInt(4);
                switch (imag) {
                case 0:

                    return R.drawable.a;
                case 1:

                    return R.drawable.b;
                case 2:

                    return R.drawable.c;
                default:

                    return R.drawable.d;
            }
        }