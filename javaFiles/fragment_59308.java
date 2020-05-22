package com.myCompany.myProduct;

public class MyClass {
    private Class<?> unityPlayerClass;
    private Field unityCurrentActivity;
    private Method unitySendMessage;

    public void init () {

        //Get the UnityPlayer class using Reflection
        unityPlayerClass = Class.forName("com.unity3d.player.UnityPlayer");
        //Get the currentActivity field
        unityCurrentActivity= unityPlayerClass.getField("currentActivity");
        //Get the UnitySendMessage method
        unitySendMessage = unityPlayerClass.getMethod("UnitySendMessage", new Class [] { String.class, String.class, String.class } );
    }

    //Use this method to get UnityPlayer.currentActivity
    public Activity currentActivity () {

        Activity activity = (Activity) unityCurrentActivity.get(unityPlayerClass);
        return activity;            
    }


    public void unitySendMessageInvoke (String gameObject, String methodName, String param) {
        //Invoke the UnitySendMessage Method
        unitySendMessage.invoke(null, new Object[] { gameObject, methodName, param} );
    }

    public void makeToast (final String toastText, final int duration) {
        currentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), toastText, duration).show();
            }
        });
    }
}