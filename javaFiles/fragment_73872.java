public void onClick(View src)
{
    int id = src.getId();
    if (id == R.id.playbtn){
        checkwificonnection();
    } else if (id == R.id.stopbtn){
        Log.d(TAG, "onClick: stopping srvice");
        Playbutton.setImageResource(R.drawable.playbtn1);
        Playbutton.setVisibility(0); //visible
        Stopbutton.setVisibility(4); //invisible
        stopService(new Intent(RakistaRadio.this,myservice.class));
        clearstatusbar();
        timer.cancel();
        Title.setText(" ");
        Artist.setText(" ");
    } else if (id == R.id.btnmenu){
        openOptionsMenu();
    }
}