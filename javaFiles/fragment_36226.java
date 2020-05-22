class SendKeyStroke extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... letter) {
        try {
            URL keyB = new URL("http://192.168.0.37:5000/keyboard/" + letter[0]);
            System.out.println(keyB.toString());

            URLConnection kb = keyB.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(kb.getInputStream(), "UTF-8"));

            String inputLine;
            StringBuilder a = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                a.append(inputLine);
            }
            in.close();
        } catch(Exception ex) {

        }

        return null;
    }
}