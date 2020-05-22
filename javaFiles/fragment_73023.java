imglist1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            prvy=DeSerializuj2(nazovtripu);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    itemimg.PociatocneBody(event.getX(),event.getY());

                    break;
                case MotionEvent.ACTION_MOVE:

                    break;
                case MotionEvent.ACTION_UP:
                    itemimg.KonecneBody(event.getX(),event.getY());
                    try {
                        prvy.Zbalene(ktore, itemimg.Spracuj());
                    } catch(IndexOutOfBoundsException e) {}
                    prvy.setHotovo(0);
                    for (int i=1;i<100;i++) {
                        prvy.Kolkomam(0,i);
                    }

                     hotovo1.setText(prvy.getHotovo()+"/"+prvy.getPocItem());



                    break;
            }

            return true;
        }
    });