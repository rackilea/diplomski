Handler viewHandler = new Handler();
Runnable updateView = new Runnable() {
@Override

public void run() {

    mEmulatorView.invalidate();

    if (statusBool == true) {
        for (int i = 1; i < dataReceived.length() - 1; i++) {

            if (dataReceived.charAt(i) == '>') {

                Log.d(TAG, "found >");
                deviceStatus = 0;
            }
            if (dataReceived.charAt(i) == '#'
                    && dataReceived.charAt(i - 1) != ')') {

                Log.d(TAG, "found #");
                deviceStatus = 1;
            }
            if ((i + 1) <= (dataReceived.length())
                    && dataReceived.charAt(i) == ')'
                    && dataReceived.charAt(i + 1) == '#') {

                Log.d(TAG, "found config )#");
                deviceStatus = 2;
            }

        }
        statusBool = false;
        viewHandler.postDelayed(updateView, 1000);

    }
}
};


public void onDataReceived(int id, byte[] data) {

dataReceived = new String(data);

statusBool = true;
Log.d(TAG, "in data received " + dataReceived);
((MyBAIsWrapper) bis).renew(data);


runOnUiThread(new Runnable(){

    @Override
    public void run() {

        mSession.write(dataReceived);

    }});


viewHandler.post(updateView);



}