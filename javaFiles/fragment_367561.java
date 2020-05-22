void onClose() {
        if(RootPanel.isInDetachList(this)) {
            RootPanel.detachNow(this);
        }
        else {
            onDetach();
        }
    }