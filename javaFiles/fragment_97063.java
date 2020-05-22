// integer is keycode, long is the time it was pressed
private HashMap<Integer, Long> keyTime = new HashMap<Integer, Long>();

@Override
public boolean keyDown(int keyCode) {

    keyTime.put(keyCode, System.currentTimeMillis());

    return true;
}

@Override
public boolean keyUp(int keyCode) {

    if(keyTime.containsKey(keyCode) {
        float time = endTime - keyTime.get(keyCode);
        System.out.println(time);
        keyTime.remove(keyCode);
    }

    return true;
}