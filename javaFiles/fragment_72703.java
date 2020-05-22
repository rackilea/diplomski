LinkedHashMap<Integer, Float> al = new LinkedHashMap<Integer, Float>();
@Override
public boolean onTouchEvent(MotionEvent event)
{
    int index = MotionEventCompat.getActionIndex(event);
    int id = event.getPointerId(index);

    float x = (int) MotionEventCompat.getX(event, index);


    @SuppressWarnings("deprecation")
    int ancho = AEngine.display.getWidth();

    switch (MotionEventCompat.getActionMasked(event))
    {
        case MotionEvent.ACTION_DOWN:
            anadir(id,x);               
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            anadir(id,x);
            break;

        case MotionEvent.ACTION_UP:
            al.remove(id);
            break;
        case MotionEvent.ACTION_POINTER_UP:         
            al.remove(id);
            break;
    }

    if(al.size() > 0)
    {
        if (gameView != null)
            gameView.touchNave(getX(al), ancho);
    }
    else 
    {
        Nave.estado = AEngine.NAVE_STAY;
    }

    return false;
}
public float getX(LinkedHashMap<Integer,Float> map) {
    Iterator<Map.Entry<Integer,Float>> iterator = map.entrySet().iterator();
    float x = 0;
    while (iterator.hasNext()) {
        x = iterator.next().getValue();
    }
    return x;
}

public void anadir(int id,float x)
{
    if (al.size() > 0 || !al.containsKey(id))
    {
        al.put(id, x);  
        Log.e("WTF",Integer.toString(id)+ "añadido");
    } 
}