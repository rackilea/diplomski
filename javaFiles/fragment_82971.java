public interface CallBack {
    void onWhatever();    
}

public enum WhateverEvent {
    INSTANCE;

    private final ArrayList<CallBack> callBacks = new ArrayList<>();

    public void register(CallBack callBack){
        callBacks.add(callBack);
    }

    private void theSingleRealCallBackTheNativeCalls(){
        for(CallBack callBack : callBacks)
            callBack.onWhatever();
    }
}