@Override
public void onClick(View iv) {
    if(works) {
        logotimer.interrupt();

    } else {
        //mCamera = Camera.open(); //remove this
        //and add strobe()
        strobe(); 
    }
}