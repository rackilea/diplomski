public void onTouchEvent(MotionEvent event)
{
    int ptrId = -1;
    int action = event.getAction();
    switch (action & MotionEvent.ACTION_MASK)
    {
        case MotionEvent.ACTION_DOWN:
            down(event.getPointerId(0), (int)event.getX(), (int)event.getY());
        break;
        case MotionEvent.ACTION_UP:
            up(event.getPointerId(0));
        break;
        case MotionEvent.ACTION_POINTER_DOWN:
            ptrId = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
            int ptrIdx = event.findPointerIndex(ptrId);
            down(ptrId, (int)event.getX(ptrIdx), (int)event.getY(ptrIdx));
        break;
        case MotionEvent.ACTION_POINTER_UP:
            ptrId = action >> MotionEvent.ACTION_POINTER_ID_SHIFT;
            up(ptrId);
        break;
        case MotionEvent.ACTION_MOVE:
            for(int i = 0; i < event.getPointerCount(); ++i)
                if(event.getPointerId(i) == inputPad.id())
                {
                    inputPad.position(event.getX(inputPad.id()));
                    player.velocity(inputPad.delta());
                    player.stand();
                    if(enemy != null) {
                        Fighter.collide(player, enemy);
                        enemy.update();
                    }
                    player.update();
                    break;
                }
        break;
    }
}