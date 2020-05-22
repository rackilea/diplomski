public void onButtonPressed(){
        // on input event from your ui component
        if(handler == null) {
            handler = new ClickHandler();
            new Thread(handler).start();
        } else {
            handler.recordNewClick();
        }
    }