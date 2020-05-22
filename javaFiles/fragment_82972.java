public enum WhateverEvent {
    INSTANCE;

    private final HashMap<Integer, CallBack> callBacks = new HashMap<>();

    public void register(int id, CallBack callBack){
        callBacks.put(id, callBack);
    }

    private void theSingleRealCallBackTheNativeCalls(int id){
        CallBack callBack : callBacks.get(id);
        if (callback != null)
            callBack.onWhatever();
    }
}