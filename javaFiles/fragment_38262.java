Drawable res1 = null;
    String uri1 = null;
    try {
        //First image
        uri1 = "@drawable/"+imageSplitted[0];
        int imageResource1 = context.getResources().getIdentifier(uri1, null, context.getApplicationContext().getPackageName());
        res1 = context.getResources().getDrawable(imageResource1);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        //int imageResource1 = context.getResources().getIdentifier(uri1, null, context.getApplicationContext().getPackageName());
        res1 = context.getResources().getDrawable(R.drawable.ic_launcher);// Default image
    }