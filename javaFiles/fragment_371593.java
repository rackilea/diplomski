public boolean onTouchEvent(MotionEvent event){

    int amount=event.getPointerCount();
    for (int i=0; i<amount; i++) {
            float x = event.getX(i);
            float y = event.getY(i);


        if (x>screenX/2 && flight.toShoot==0){
            flight.toShoot++;
        }

        if (x<screenX/2 -100 && flyingenabled)
        {
            flight.x = (int) x - 100;
            flight.y = (int) y - 50;
        }



    }
    return true;
}