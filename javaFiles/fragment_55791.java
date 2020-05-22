class ReceiveData extends AsyncTask<Void, Void, Boolean> {
    String volts;
    String amps;

    protected Boolean doInBackground(Void... args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(LoginActivity.getSocket().getInputStream()));
            str = in.readLine();
            String[] strrecv= store.split("|");
            volts = strrecv[0];
            amps = strrecv[1];
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected void onPostExecute(Boolean result) {
        if (result) {
            tbvolts.setText("Voltage: " + volts + " V");
            tbamps.setText("Amperes:" + amps + " A");
        }
    }
}