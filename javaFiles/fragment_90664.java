public void sendMysong(String songname,String imgUrl,String text)
    {
    Intent myIntent = new Intent(this, NewActivityClassName.class);
    myIntent.putExtra("soundfile",songname);
    myIntent.putExtra("image",imgUrl);
    myIntent.putExtra("text",text);
    }