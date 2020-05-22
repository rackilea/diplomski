if(dataList!=null && dataList.size()==0) {
        if (savedInstanceState==null) {
            //your api call to load from net
        } else {
            if (savedInstanceState.getBoolean("savedState")) {
                //If you have saved data in state save, load it here
            } else {
                //only fire the async if the current fragment is the one visible, else the onResumeAndShowFragment will trigger the same async when it becomes visible
                if (savedInstanceState.getBoolean("amIVisible")) {
                    //Load data from net
                }
            }
        }
    }