send_object.sendPOST(getApplicationContext(), url, data, new ResponseCallback() {
            @Override
            public void myResponseCallback(String result) {
 //here, this result parameter that comes through is your api call result to use, so use this result right here to do any operation you previously wanted to do.
            }
        });