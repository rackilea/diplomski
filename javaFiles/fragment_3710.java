try to use varible like 
boolean change = flase ;

a1.setClickable(false);
                a2.setClickable(false);
                a3.setClickable(false);
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);
                c1.setClickable(false);
                c2.setClickable(false);
                c3.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        a1.setClickable(true);
                        a2.setClickable(true);
                        a3.setClickable(true);
                        b1.setClickable(true);
                        b2.setClickable(true);
                        b3.setClickable(true);
                        c1.setClickable(true);
                        c2.setClickable(true);
                        c3.setClickable(true);
                        change = true ;

                    }
                }, 5000);