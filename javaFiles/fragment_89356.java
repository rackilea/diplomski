b1.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {

        Intent i;
        switch(getlevstate(myContext)) {
            case 1:
                i = new Intent(myContext, Lev1Activity.class);
                break;
            case 2:
                i = new Intent(myContext, Lev2Activity.class);
                break;
            case 3:
                i = new Intent(myContext, Lev3Activity.class);
                break;
            case 4
                i = new Intent(myContext, Lev4Activity.class);
                break;
            ...
        }

        startActivity(i);
    }

});