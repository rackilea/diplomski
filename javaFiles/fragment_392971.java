int saved_x = -1;
int saved_y = -1;

@Override
public boolean onTouchEvent(MotionEvent event)
{
    final int action = event.getAction();
    final int pointer_index = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
    int pid = event.getPointerId(pointer_index);

    int x = (int)event.getX();
    int y = (int)event.getY();

    switch (action & MotionEvent.ACTION_MASK)
    {
        case MotionEvent.ACTION_DOWN:
            saved_x = x;
            saved_y = y;
            break;

        case MotionEvent.ACTION_MOVE:
            int relative_x = x - saved_x;
            int relative_y = y - saved_y;

            //move right --> relative_x increases by 'm' pixels of movement
            //move left  --> relative_x decreases by 'm' pixels of movement
            //move down  --> relative_y increases by 'm' pixels of movement
            //move up    --> relative_y decreases by 'm' pixels of movement

            //use it :D
            break;

        case MotionEvent.ACTION_UP:
            saved_x = -1; //-1 indicates "no finger on screen" -- just a feature :)
            saved_y = -1; //-1 indicates "no finger on screen" -- just a feature :)
            break;
    }

    return true;
}