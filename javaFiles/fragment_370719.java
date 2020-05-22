class CautaProbleme extends AsyncTask<Void, Void, String> {

    ....

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ....

        createButtonDynamically();
    }
}