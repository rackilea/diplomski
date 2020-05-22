public void NotifyWithFlash(Context context){

    boolean ShouldIGlow = true;

    while(ShouldIGlow){
        flashON();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ShouldIGlow = false;
            flashOFF();
        }

    }
}


public void flashON(){
    cam = Camera.open();     
    Parameters p = cam.getParameters();
    p.setFlashMode(Parameters.FLASH_MODE_TORCH);
    cam.setParameters(p);
    cam.startPreview();

}

public void flashOFF(){
    cam.stopPreview();
    cam.release(); 
}