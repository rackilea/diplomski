View myView1 = new  View(this);
            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(480,
                    900);
            myView1.setLayoutParams(params1);
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.relative1);
            myView1.setBackgroundColor(Color.YELLOW);

            if (layout!=null){

            layout.removeAllViews();//Remove all views here
            layout.addView(myView1);// add views again

            } else{
                layout.addView(myView1);// add views as you do it before
            }